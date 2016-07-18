/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.Expression;

public abstract class BinaryExpression implements Expression {

    private Expression left;
    private Expression right;

    public BinaryExpression(Expression left, Expression right) {
        if (left == null || right == null)
            throw new IllegalArgumentException();
        this.left = left;
        this.right = right;
    }

    public Expression getLeftExpression() {
        return this.left;
    }

    public Expression getRightExpression() {
        return this.right;
    }

}
