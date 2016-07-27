package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.compiler.Scope;
import net.rpgtoolkit.blade.ir.symbols.Symbol;

public interface ScopedSymbol extends Symbol {

  Scope getScope();

}
