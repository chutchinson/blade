/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.AbstractNode;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class ConstantStringExpression extends AbstractNode implements ConstantExpression {

  private String value;

  public ConstantStringExpression(SourceRange range, String value) {
    super(range);
    setValue(value);
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
