/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import java.util.LinkedList;
import java.util.List;

public class Block implements Node {

    private final List<Statement> statements;

    public Block() {
        this.statements = new LinkedList<>();
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
