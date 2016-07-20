/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.symbols;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private final SymbolTable parent;
    private final Map<String, Symbol> symbols;

    public SymbolTable(SymbolTable enclosing) {
        this.parent = enclosing;
        this.symbols = new HashMap<>();
    }

    public boolean isGlobalScope() {
        return (this.parent == null);
    }

    public SymbolTable getEnclosingScope() {
        return this.parent;
    }

    public boolean contains(String name) {
        if (symbols.containsKey(name))
            return true;
        if (parent != null)
            return parent.contains(name);
        return false;
    }

    public boolean insert(Symbol sym) {

        if (sym == null)
            throw new IllegalArgumentException();

        final String name = sym.getName();
        if (contains(name)) {
            symbols.put(name, sym);
            return true;
        }

        return false;

    }

    public Symbol lookup(String name) {
        return lookup(name, true);
    }

    public Symbol lookup(String name, boolean recurse) {
        if (name == null)
            throw new IllegalArgumentException();
        if (symbols.containsKey(name))
            return symbols.get(name);
        if (parent != null && recurse)
            return parent.lookup(name);
        return null;
    }

}
