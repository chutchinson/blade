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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CallExpression implements Expression {

    private Expression target;
    private final List<Expression> arguments;

    public CallExpression(Expression target, Collection<Expression> arguments) {
        this.arguments = new LinkedList<>();
        setTarget(target);
        setArguments(arguments);
    }

    public List<Expression> getArguments() {
        return this.arguments;
    }

    public Expression getTarget() {
        return this.target;
    }

    public void setTarget(Expression target) {
        if (target == null)
            throw new IllegalArgumentException();
        this.target = target;
    }

    public void setArguments(Collection<Expression> arguments) {
        this.arguments.clear();
        this.arguments.addAll(arguments);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

}
