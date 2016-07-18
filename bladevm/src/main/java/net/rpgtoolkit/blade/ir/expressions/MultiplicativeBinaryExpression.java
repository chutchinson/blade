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

public class MultiplicativeBinaryExpression extends BinaryExpression {

    public enum Operator {
        MULTIPLY,
        DIVIDE,
        MODULUS,
        POWER
    }

    private Operator op;

    public MultiplicativeBinaryExpression(Operator op, Expression left, Expression right) {
        super(left, right);
        this.op = op;
    }

    public Operator getOperator() {
        return this.op;
    }

    public void setOperator(Operator op) {
        this.op = op;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
