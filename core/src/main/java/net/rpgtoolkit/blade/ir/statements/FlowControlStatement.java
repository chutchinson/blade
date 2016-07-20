/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class FlowControlStatement extends AbstractStatement {

    public enum FlowControlKind {
        BREAK,
        CONTINUE,
        GOTO
    }

    private FlowControlKind kind;

    public FlowControlStatement(SourceRange range, FlowControlKind kind) {
        super(range);
        setKind(kind);
    }

    public FlowControlKind getKind() {
        return this.kind;
    }

    public void setKind(FlowControlKind kind) {
        this.kind = kind;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
