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

    private Identifier symbol;
    private Expression index;

    public IndexExpression(SourceRange range, Identifier sym) {
        super(range);
        setSymbol(sym);
    }

    public Identifier getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Identifier sym) {
        if (sym == null)
            throw new IllegalArgumentException();
        this.symbol = sym;
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
