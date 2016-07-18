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

public class CompilationUnit implements Node {

    private final List<ClassDeclaration> classes;
    private final List<FunctionDeclaration> functions;

    public CompilationUnit() {
        this.classes = new ArrayList<>();
        this.functions = new ArrayList<>();
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

}
