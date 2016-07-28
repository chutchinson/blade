/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.Expression;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class ReturnStatement extends AbstractStatement {

  private Expression expr;

  public ReturnStatement(SourceRange range) {
    super(range);
  }

  public Expression getExpression() {
    return this.expr;
  }

  public void setExpression(Expression expr) {
    this.expr = expr;
    if (this.expr != null) {
      this.expr.setParent(this);
    }
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
