/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.expressions;

import net.rpgtoolkit.blade.ir.*;

public class IndexExpression extends AbstractNode implements Expression {

    private Identifier identifier;
    private Expression index;

    public IndexExpression(SourceRange range, Identifier ident) {
        super(range);
        setIdentifier(ident);
    }

    public Identifier getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(Identifier ident) {
        if (ident == null)
            throw new IllegalArgumentException();
        this.identifier = ident;
    }

    public Expression getIndexExpression() {
        return this.index;
    }

    public void setIndexExpression(Expression expr) {
        this.index = expr;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}
