/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.AbstractNode;
import net.rpgtoolkit.blade.ir.Expression;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class AssignmentExpression extends AbstractNode implements Expression {

  public enum Operator {
    ASSIGN,
    ASSIGN_ADD,
    ASSIGN_SUB,
    ASSIGN_MUL,
    ASSIGN_DIV,
    ASSIGN_MOD,
    ASSIGN_POW,
    ASSIGN_SHL,
    ASSIGN_SHR,
    ASSIGN_AND,
    ASSIGN_OR,
    ASSIGN_XOR
  }

  private Operator op;
  private Expression symbol;
  private Expression value;

  public AssignmentExpression(SourceRange range, Operator op, Expression sym, Expression value) {
    super(range);
    setOperator(op);
    setSymbolExpression(sym);
    setValueExpression(value);
  }

  public Operator getOperator() {
    return this.op;
  }

  public void setOperator(Operator op) {
    this.op = op;
  }

  public Expression getSymbolExpression() {
    return this.symbol;
  }

  public void setSymbolExpression(Expression sym) {
    if (sym == null)
      throw new IllegalArgumentException();
    this.symbol = sym;
    this.symbol.setParent(this);
  }

  public Expression getValueExpression() {
    return this.value;
  }

  public void setValueExpression(Expression value) {
    if (value == null)
      throw new IllegalArgumentException();
    this.value = value;
    this.value.setParent(this);
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
