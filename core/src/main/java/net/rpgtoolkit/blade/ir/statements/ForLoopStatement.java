/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.Block;
import net.rpgtoolkit.blade.ir.Expression;
import net.rpgtoolkit.blade.ir.NodeVisitor;
import net.rpgtoolkit.blade.ir.SourceRange;

public class ForLoopStatement extends AbstractStatement {

    private Expression initial;
    private Expression condition;
    private Expression iterator;
    private Block body;

    public ForLoopStatement(SourceRange range) {
        super(range);
    }

    public Expression getInitialExpression() {
        return this.initial;
    }

    public void setInitialExpression(Expression expr) {
        this.initial = expr;
    }

    public Expression getConditionExpression() {
        return this.condition;
    }

    public void setConditionExpression(Expression condition) {
        this.condition = condition;
    }

    public Expression getIteratorExpression() {
        return this.iterator;
    }

    public void setIteratorExpression(Expression expr) {
        this.iterator = expr;
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
