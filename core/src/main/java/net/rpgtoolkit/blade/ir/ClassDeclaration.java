/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclaration extends AbstractNode {

  private Identifier name;
  private final List<Identifier> inheritanceList;
  private final List<FunctionDeclaration> functions;
  private final List<ClassFieldDeclaration> fields;

  public ClassDeclaration(SourceRange range, Identifier name) {
    super(range);
    this.functions = new ArrayList<>();
    this.fields = new ArrayList<>();
    this.inheritanceList = new ArrayList<>();
    setName(name);
  }

  public List<Identifier> getInheritanceList() {
    return this.inheritanceList;
  }

  public List<FunctionDeclaration> getFunctionDeclarations() {
    return this.functions;
  }

  public List<ClassFieldDeclaration> getFieldDeclarations() {
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
