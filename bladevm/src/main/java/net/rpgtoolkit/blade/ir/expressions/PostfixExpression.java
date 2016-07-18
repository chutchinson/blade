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

public class PostfixExpression implements Expression {

    public enum Operator {
        INCREMENT,
        DECREMENT
    }

    private Operator op;
    private Expression lhs;

    public PostfixExpression(Operator op, Expression lhs) {
        setOperator(op);
        setExpression(lhs);
    }

    public Operator getOperator() {
        return this.op;
    }

    public void setOperator(Operator op) {
        this.op = op;
    }

    public Expression getExpression() {
        return this.lhs;
    }

    public void setExpression(Expression expr) {
        this.lhs = expr;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
