/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.Identifier;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.Statement;

public class LabelStatement implements Statement {

    private Identifier name;

    public LabelStatement(Identifier name) {
        setName(name);
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
