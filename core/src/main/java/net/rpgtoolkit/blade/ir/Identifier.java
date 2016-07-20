/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class Identifier extends AbstractNode{

  private String value;

  public Identifier(SourceRange range, String value) {
    super(range);
    this.setValue(value);
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    if (value == null)
      throw new IllegalArgumentException();
    this.value = value;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return this.value;
  }

}
