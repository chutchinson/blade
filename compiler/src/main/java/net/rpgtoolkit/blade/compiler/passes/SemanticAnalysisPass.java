/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler.passes;

import com.sun.org.apache.xpath.internal.compiler.Compiler;

import net.rpgtoolkit.blade.compiler.*;
import net.rpgtoolkit.blade.compiler.attributes.UnreachableCodeAttribute;
import net.rpgtoolkit.blade.compiler.symbols.FunctionSymbol;
import net.rpgtoolkit.blade.compiler.symbols.ProgramSymbol;
import net.rpgtoolkit.blade.compiler.symbols.VariableSymbol;
import net.rpgtoolkit.blade.ir.AbstractNodeVisitor;
import net.rpgtoolkit.blade.ir.Block;
import net.rpgtoolkit.blade.ir.CompilationUnit;
import net.rpgtoolkit.blade.ir.FunctionDeclaration;
import net.rpgtoolkit.blade.ir.Identifier;
import net.rpgtoolkit.blade.ir.NodeCollection;
import net.rpgtoolkit.blade.ir.Parameter;
import net.rpgtoolkit.blade.ir.SourceLocation;
import net.rpgtoolkit.blade.ir.Statement;
import net.rpgtoolkit.blade.ir.expressions.AssignmentExpression;
import net.rpgtoolkit.blade.ir.statements.ErrorHandlerStatement;
import net.rpgtoolkit.blade.ir.statements.ExpressionStatement;
import net.rpgtoolkit.blade.ir.statements.FlowControlStatement;
import net.rpgtoolkit.blade.ir.statements.ForLoopStatement;
import net.rpgtoolkit.blade.ir.statements.LoopStatement;
import net.rpgtoolkit.blade.ir.statements.ReturnStatement;

import java.util.Collection;
import java.util.List;

/**
 * Encapsulates the semantic analysis phase of the Blade compiler. This pass performs the
 * following actions:
 *
 * <ul>
 * <li>Detect common mistakes</li>
 * <li>Detect duplicate declarations</li>
 * <li>Detect invalid IR expression trees</li>
 * <li>Type checking</li>
 * </ul>
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class SemanticAnalysisPass implements CompilerPass {

  private class SymbolDefinitionVisitor extends AbstractNodeVisitor {

    private ProgramSymbol currentProgram;
    private FunctionSymbol currentFunction;
    private Scope currentScope;

    public void visit(CompilationUnit unit) {

      // define a top-level program symbol

      final Scope globalScope = context.getGlobalScope();
      final ProgramSymbol symbol = new ProgramSymbol(globalScope,
          unit.getSourceRange(), unit.getName());

      unit.setSymbol(symbol);

      currentScope = globalScope;
      currentProgram = symbol;

      // define function symbols

      for (final FunctionDeclaration fn : unit.getFunctionDeclarations()) {
        currentScope = symbol.getScope();
        fn.accept(this);
        final FunctionSymbol fnsym = (FunctionSymbol) fn.getSymbol();
        if (fnsym != null)
          symbol.function(fnsym);
      }

    }

    public void visit(FunctionDeclaration node) {

      final String name = node.getName().getValue();

      // detect duplicate function declarations

      if (currentScope.contains(name)) {
        final SourceLocation loc = node.getSourceRange().getStartLocation();
        context.message(new CompilerMessage(CompilerMessage.Severity.ERROR,
            loc.getLine(), loc.getColumn(), 0x00,
            String.format("duplicate function declaration <%s>", name)));
        return;
      }

      final FunctionSymbol symbol =
          new FunctionSymbol(currentScope, node.getSourceRange(), name);

      currentFunction = symbol;
      currentScope = symbol.getScope();

      // define function parameter symbols

      for (final Parameter param : node.getParameters()) {
        param.accept(this);
      }

      // define function body symbols

      if (node.getBody() != null) {
        final NodeCollection<Statement> statements = node.getBody().getStatements();
        for (final Statement stmt : statements) {
          stmt.accept(this);
        }
      }

      currentFunction = null;

    }

    public void visit(Parameter node) {

      final String name = node.getName().getValue();

      // detect duplicate parameter declarations

      if (currentScope.contains(name)) {
        context.message(CompilerMessageFactory.error(0x00, node.getSourceRange(),
            "duplicate parameter declaration <%s>", name));
        return;
      }

      // insert parameter into current function

      final VariableSymbol symbol = new VariableSymbol(node.getSourceRange(), name);
      currentFunction.parameter(symbol);

    }

    public void visit(ExpressionStatement node) {

      // forward to stored expression

      node.getExpression().accept(this);

    }

    public void visit(AssignmentExpression node) {

      // ensure lhs of assignment is an identifier

      if (!(node.getSymbolExpression() instanceof Identifier)) {
        context.message(CompilerMessageFactory.error(0x00, node.getSourceRange(),
            "left-side of assignment must be a variable"));
        return;
      }

      final Identifier ident = (Identifier) node.getSymbolExpression();
      final String name = ident.getValue();

      // insert variable symbol into current scope if it doesn't exist; otherwise,
      // the assignment will refer to a function parameter

      if (!currentScope.contains(name)) {
        final VariableSymbol symbol = new VariableSymbol(ident.getSourceRange(), name);
        currentScope.insert(symbol);
      }

    }

  }

  private class FlowControlVisitor extends AbstractNodeVisitor {

    private boolean insideLoop = false;
    private boolean returned = false;

    public void visit(ReturnStatement node) {

      returned = true;

    }

    public void visit(ForLoopStatement node) {

      insideLoop = true;
      node.getBody().accept(this);
      insideLoop = false;

    }

    public void visit(LoopStatement node) {

      insideLoop = true;
      node.getBody().accept(this);
      insideLoop = false;

    }

    public void visit(FlowControlStatement node) {

      // detect break / continue statements outside of loops

      switch (node.getKind()) {
        case BREAK:
        case CONTINUE:
          if (!insideLoop) {
            node.getAttributes().put(
                new UnreachableCodeAttribute(UnreachableCodeAttribute.Reason.UNNESTED));
            context.message(CompilerMessageFactory.error(
                0x00, node.getSourceRange(), "flow control outside of loop"));
          }
          returned = true;
          break;
      }

    }

    public void visit(Block node) {

      returned = false;

      final NodeCollection<Statement> statements = node.getStatements();

      // detect unreachable code

      for (final Statement stmt : statements) {
        if (returned) {
          node.getAttributes().put(
              new UnreachableCodeAttribute(UnreachableCodeAttribute.Reason.FOLLOWS_RETURN));
          context.message(CompilerMessageFactory.warn(
              0x00, stmt.getSourceRange(), "unreachable code"));
        }
        stmt.accept(this);
      }

    }

  }

  private Compilation context;
  private SymbolDefinitionVisitor symbolDefinitionVisitor;
  private FlowControlVisitor flowControlVisitor;

  @Override
  public void initialize(Compilation context) {
    if (context == null)
      throw new IllegalArgumentException();
    this.context = context;
    this.symbolDefinitionVisitor = new SymbolDefinitionVisitor();
    this.flowControlVisitor = new FlowControlVisitor();
  }

  @Override
  public void process(Compilation context) throws CompilerException {
    final CompilationUnit unit = context.getCompilationUnit();
    unit.accept(this.symbolDefinitionVisitor);
    unit.accept(this.flowControlVisitor);
  }

}
