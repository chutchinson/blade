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
import net.rpgtoolkit.blade.ir.SourceRange;

public abstract class BinaryExpression extends AbstractNode implements Expression {

  private Expression left;
  private Expression right;

  public BinaryExpression(SourceRange range, Expression left, Expression right) {
    super(range);
    this.setLeftExpression(left);
    this.setRightExpression(right);
  }

  public Expression getLeftExpression() {
    return this.left;
  }

  public void setLeftExpression(Expression expr) {
    if (expr == null)
      throw new IllegalArgumentException();
    this.left = expr;
    this.left.setParent(this);
  }

  public Expression getRightExpression() {
    return this.right;
  }

  public void setRightExpression(Expression expr) {
    if (expr == null)
      throw new IllegalArgumentException();
    this.right = expr;
    this.right.setParent(this);
  }

}
