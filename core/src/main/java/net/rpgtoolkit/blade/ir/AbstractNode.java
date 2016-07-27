/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import net.rpgtoolkit.blade.ir.attributes.NodeAttribute;
import net.rpgtoolkit.blade.ir.symbols.Symbol;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractNode implements Node {

  protected final SourceRange range;
  protected final NodeAttributeCollection attributes;
  private Symbol symbol;

  public AbstractNode(SourceRange range) {
    if (range == null)
      throw new IllegalArgumentException();
    this.range = range;
    this.attributes = new NodeAttributeCollection();
  }

  public NodeAttributeCollection getAttributes() {
    return this.attributes;
  }

  public Symbol getSymbol() {
    return this.symbol;
  }

  public void setSymbol(Symbol sym) {
    this.symbol = sym;
  }

  public SourceRange getSourceRange() {
    return this.range;
  }

  public abstract void accept(NodeVisitor visitor);

}
