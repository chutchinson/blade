/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Block extends AbstractNode
    implements Iterable<Statement> {

  private final List<Statement> statements;

  public Block(SourceRange range) {
    super(range);
    this.statements = new LinkedList<>();
  }

  public int size() {
    return this.statements.size();
  }

  public boolean contains(Statement stmt) {
    return this.statements.contains(stmt);
  }

  public Statement get(int index) {
    return this.statements.get(index);
  }

  public void add(Statement stmt) {
    if (stmt != null) {
      stmt.setParent(this);
      this.statements.add(stmt);
    }
  }

  public void remove(Statement stmt) {
    if (this.statements.remove(stmt)) {
      stmt.setParent(null);
    }
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Iterator<Statement> iterator() {
    return this.statements.iterator();
  }
}
