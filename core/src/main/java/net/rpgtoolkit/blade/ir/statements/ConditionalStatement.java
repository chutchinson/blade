/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.*;

public class ConditionalStatement extends AbstractStatement {

    private Expression condition;
    private Block body;

    public ConditionalStatement(SourceRange range, Expression expr, Block body) {
        super(range);
        setConditionExpression(expr);
        setBody(body);
    }

    public Expression getConditionExpression() {
        return this.condition;
    }

    public void setConditionExpression(Expression expr) {
        if (expr == null)
            throw new IllegalArgumentException();
        this.condition = expr;
    }

    public Block getBody() {
        return this.body;
    }

    public void setBody(Block body) {
        if (body == null)
            throw new IllegalArgumentException();
        this.body = body;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
