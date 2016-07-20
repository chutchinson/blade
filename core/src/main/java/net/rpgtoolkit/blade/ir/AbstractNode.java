/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public abstract class AbstractNode implements Node {

  protected final SourceRange range;

  public AbstractNode(SourceRange range) {
    if (range == null)
      throw new IllegalArgumentException();
    this.range = range;
  }

  public SourceRange getSourceRange() {
    return this.range;
  }

  public abstract void accept(NodeVisitor visitor);

}
