/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.Expression;
import net.rpgtoolkit.blade.ir.NodeVisitor;

public class UnaryExpression implements Expression {

    public enum Operator {
        POSITIVE,
        NEGATIVE
    }

    private Operator op;
    private Expression expr;

    public UnaryExpression(Operator op, Expression expr) {
        setOperator(op);
        setExpression(expr);
    }

    public Operator getOperator() {
        return this.op;
    }

    public void setOperator(Operator op) {
        this.op = op;
    }

    public Expression getExpression() {
        return this.expr;
    }

    public void setExpression(Expression expr) {
        if (expr == null)
            throw new IllegalArgumentException();
        this.expr = expr;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
