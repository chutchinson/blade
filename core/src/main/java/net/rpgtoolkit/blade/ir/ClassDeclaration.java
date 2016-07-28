/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class ClassDeclaration extends AbstractNode {

  private Identifier name;
  private final NodeCollection<Identifier> inheritanceList;
  private final NodeCollection<FunctionDeclaration> functions;
  private final NodeCollection<ClassFieldDeclaration> fields;

  public ClassDeclaration(SourceRange range, Identifier name) {
    super(range);
    this.functions = new LinkedNodeCollection<>(this);
    this.fields = new LinkedNodeCollection<>(this);
    this.inheritanceList = new LinkedNodeCollection<>(this);
    setName(name);
  }

  public NodeCollection<Identifier> getInheritanceList() {
    return this.inheritanceList;
  }

  public NodeCollection<FunctionDeclaration> getFunctionDeclarations() {
    return this.functions;
  }

  public NodeCollection<ClassFieldDeclaration> getFieldDeclarations() {
    return this.fields;
  }

  public Identifier getName() {
    return this.name;
  }

  public void setName(Identifier name) {
    if (name == null)
      throw new IllegalArgumentException();
    this.name = name;
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

}
