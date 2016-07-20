/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class Parameter extends AbstractNode {

  private Identifier name;

  public Parameter(SourceRange range, Identifier name) {
    super(range);
    this.setName(name);
  }

  public Identifier getName() {
    return this.name;
  }

  public void setName(Identifier value) {
    if (value == null)
      throw new IllegalArgumentException();
    this.name = value;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
