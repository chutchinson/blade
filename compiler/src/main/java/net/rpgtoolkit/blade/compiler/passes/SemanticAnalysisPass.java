package net.rpgtoolkit.blade.compiler.passes;

import net.rpgtoolkit.blade.compiler.*;
import net.rpgtoolkit.blade.compiler.symbols.FunctionSymbol;
import net.rpgtoolkit.blade.compiler.symbols.ProgramSymbol;
import net.rpgtoolkit.blade.compiler.symbols.VariableSymbol;
import net.rpgtoolkit.blade.ir.AbstractNodeVisitor;
import net.rpgtoolkit.blade.ir.CompilationUnit;
import net.rpgtoolkit.blade.ir.FunctionDeclaration;
import net.rpgtoolkit.blade.ir.Identifier;
import net.rpgtoolkit.blade.ir.Parameter;
import net.rpgtoolkit.blade.ir.SourceLocation;
import net.rpgtoolkit.blade.ir.Statement;
import net.rpgtoolkit.blade.ir.expressions.AssignmentExpression;
import net.rpgtoolkit.blade.ir.expressions.ConstantNumberExpression;
import net.rpgtoolkit.blade.ir.expressions.MultiplicativeBinaryExpression;
import net.rpgtoolkit.blade.ir.statements.ExpressionStatement;

/**
 * Encapsulates the semantic analysis phase of the Blade compiler. This pass performs the
 * following actions:
 *
 * <ul>
 *   <li>Detect common mistakes</li>
 *   <li>Detect duplicate declarations</li>
 *   <li>Detect invalid IR expression trees</li>
 *   <li>Type checking</li>
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

      // create a top-level program symbol

      final Scope globalScope = context.getGlobalScope();
      final ProgramSymbol symbol = new ProgramSymbol(globalScope,
          unit.getSourceRange(), unit.getName());

      unit.setSymbol(symbol);

      currentScope = globalScope;
      currentProgram = symbol;

      // create function symbols

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

      // create function parameter symbols

      for (final Parameter param : node.getParameters()) {
        param.accept(this);
      }

      // create function body symbols

      if (node.getBody() != null) {
        for (final Statement stmt : node.getBody().getStatements()) {
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

  private class LogicalAnalysisVisitor extends AbstractNodeVisitor {

    public void visit(CompilationUnit node) {

      for (final FunctionDeclaration fn : node.getFunctionDeclarations()) {
        fn.accept(this);
      }

    }

    public void visit(FunctionDeclaration node) {

      if (node.getBody() != null) {
        for (final Statement stmt : node.getBody().getStatements()) {
          stmt.accept(this);
        }
      }

    }

    public void visit(ExpressionStatement node) {

      node.getExpression().accept(this);

    }

    public void visit(MultiplicativeBinaryExpression node) {

      // forbid division by zero

      if (node.getRightExpression() instanceof ConstantNumberExpression) {
        final ConstantNumberExpression rhs = (ConstantNumberExpression) node.getRightExpression();
        if (rhs.getValue() == 0) {
          switch (node.getOperator()) {
            case DIVIDE:
            case DIVIDE_INT:
            case MODULUS:
              context.message(CompilerMessageFactory.error(0x00, node.getSourceRange(),
                  "division by zero"));
              return;
          }
        }
      }

    }

  }

  private Compilation context;
  private SymbolDefinitionVisitor symbolDefinitionVisitor;

  @Override
  public void initialize(Compilation context) {
    if (context == null)
      throw new IllegalArgumentException();
    this.context = context;
    this.symbolDefinitionVisitor = new SymbolDefinitionVisitor();
  }

  @Override
  public void process(Compilation context) throws CompilerException {

  }

}
