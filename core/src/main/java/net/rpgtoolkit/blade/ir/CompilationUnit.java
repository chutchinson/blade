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
import java.util.UUID;

public class CompilationUnit extends AbstractNode {

    private final String name;
    private final List<ClassDeclaration> classes;
    private final List<FunctionDeclaration> functions;

    public CompilationUnit(SourceRange range, String name) {
        super(range);
        this.classes = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.name = (name != null) ? name : generateUniqueName();
    }

    public String getName() {
        return this.name;
    }

    public List<ClassDeclaration> getClassDeclarations() {
        return this.classes;
    }

    public List<FunctionDeclaration> getFunctionDeclarations() {
        return this.functions;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    private static final String generateUniqueName() {
        return UUID.randomUUID().toString();
    }

}
