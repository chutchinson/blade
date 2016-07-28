/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class Block extends AbstractNode {

  private final NodeCollection<Statement> statements;

  public Block(SourceRange range) {
    super(range);
    this.statements = new LinkedNodeCollection<>(this);
  }

  public NodeCollection getStatements() {
    return this.statements;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
