package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.ir.SourceRange;

public class VariableSymbol extends AbstractSymbol {

  public VariableSymbol(SourceRange range, String name) {
    super(range, name);
  }

}
