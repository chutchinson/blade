/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.Expression;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class LogicalBinaryExpression extends BinaryExpression {

  public enum Operator {
    AND,
    OR
  }

  private Operator op;

  public LogicalBinaryExpression(SourceRange range, Operator op, Expression lhs, Expression rhs) {
    super(range, lhs, rhs);
    setOperator(op);
  }

  public Operator getOperator() {
    return this.op;
  }

  public void setOperator(Operator op) {
    this.op = op;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
