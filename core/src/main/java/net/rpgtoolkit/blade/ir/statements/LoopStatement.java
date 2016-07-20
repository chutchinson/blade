/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.*;

public class LoopStatement extends AbstractStatement {

    public enum LoopKind {
        DO,
        WHILE,
        UNTIL
    }

    private LoopKind kind;
    private Expression condition;
    private Block body;

    public LoopStatement(SourceRange range, LoopKind kind, Expression condition) {
        super(range);
        setKind(kind);
        setCondition(condition);
    }

    public LoopKind getKind() {
        return this.kind;
    }

    public void setKind(LoopKind kind) {
        this.kind = kind;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public void setCondition(Expression condition) {
        if (condition == null)
            throw new IllegalArgumentException();
        this.condition = condition;
    }

    public Block getBody() {
        return this.body;
    }

    public void setBody(Block body) {
        this.body = body;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
