package net.rpgtoolkit.blade.ir.symbols;

import net.rpgtoolkit.blade.ir.SourceRange;

public abstract class AbstractSymbol implements Symbol {

    protected SourceRange range;

    public AbstractSymbol(SourceRange range) {
        if (range == null)
            throw new IllegalArgumentException();
        this.range = range;
    }

    public SourceRange getSourceRange() {
        return this.range;
    }

    public abstract String getName();

}
