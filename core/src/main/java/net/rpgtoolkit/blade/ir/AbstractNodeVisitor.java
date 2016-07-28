/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import net.rpgtoolkit.blade.ir.expressions.*;
import net.rpgtoolkit.blade.ir.statements.*;

public abstract class AbstractNodeVisitor implements NodeVisitor {

  public void visit(CompilationUnit node) {
    for (final FunctionDeclaration fn : node.getFunctionDeclarations()) {
      fn.accept(this);
    }
  }

  public void visit(Parameter node) { }

  public void visit(ClassDeclaration node) {
    for (final FunctionDeclaration fn : node.getFunctionDeclarations()) {
      fn.accept(this);
    }
  }

  public void visit(ClassFieldDeclaration node) {
  }

  public void visit(FunctionDeclaration node) {
    for (final Parameter param : node.getParameters()) {
      param.accept(this);
    }
    if (node.getBody() != null) {
      node.getBody().accept(this);
    }
  }

  public void visit(Block node) {
    for (final Statement stmt : node) {
      stmt.accept(this);
    }
  }

  public void visit(ReturnStatement node) {
    final Expression expr = node.getExpression();
    if (expr != null)
      expr.accept(this);
  }

  public void visit(ConditionalStatement node) {
    node.getConditionExpression().accept(this);
    node.getBody().accept(this);
  }

  public void visit(ExpressionStatement node) {
    node.getExpression().accept(this);
  }

  public void visit(LoopStatement node) {
    node.getCondition().accept(this);
    final Block body = node.getBody();
    if (body != null)
      body.accept(this);
  }

  public void visit(ForLoopStatement node) {
    final Expression initial = node.getInitialExpression();
    if (initial != null)
      initial.accept(this);
    final Expression condition = node.getConditionExpression();
    if (condition != null)
      condition.accept(this);
    final Expression iterator = node.getIteratorExpression();
    if (iterator != null)
      iterator.accept(this);
    final Block body = node.getBody();
    if (body != null)
      body.accept(this);

  }

  public void visit(FlowControlStatement node) {
  }

  public void visit(LabelStatement node) {
  }

  public void visit(Identifier node) {
  }

  public void visit(UnaryExpression node) {
    node.getExpression().accept(this);
  }

  public void visit(CallExpression node) {
    for (final Expression arg : node.getArguments()) {
      arg.accept(this);
    }
  }

  public void visit(ConstantNumberExpression node) {
  }

  public void visit(ConstantStringExpression node) {
  }

  public void visit(ConstantBooleanExpression node) {
  }

  public void visit(AdditiveBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(MultiplicativeBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(RelationalBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(ShiftBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(LogicalBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(BitwiseBinaryExpression node) {
    node.getLeftExpression().accept(this);
    node.getRightExpression().accept(this);
  }

  public void visit(AssignmentExpression node) {
    node.getSymbolExpression().accept(this);
    node.getValueExpression().accept(this);
  }

  public void visit(IndexExpression node) {
    final Expression expr = node.getIndexExpression();
    if (expr != null)
      expr.accept(this);
  }

  public void visit(PostfixExpression node) {
    final Expression expr = node.getExpression();
    if (expr != null)
      expr.accept(this);
  }

  public void visit(ErrorHandlerStatement node) { }

}
