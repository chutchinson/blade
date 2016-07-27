package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.compiler.Scope;
import net.rpgtoolkit.blade.ir.SourceRange;

import java.util.HashMap;
import java.util.Map;

public class ProgramSymbol extends AbstractScopedSymbol {

  private Map<String, FunctionSymbol> functions;

  public ProgramSymbol(Scope enclosing, SourceRange range, String name) {
    super(enclosing, range, name);
    this.functions = new HashMap<>();
  }

  public void function(FunctionSymbol symbol) {
    if (symbol == null)
      return;
    this.functions.put(symbol.getName(), symbol);
  }

}
