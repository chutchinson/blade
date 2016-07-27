package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.compiler.Scope;
import net.rpgtoolkit.blade.ir.SourceRange;

import java.util.HashMap;
import java.util.Map;

/**
 * Function symbol.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class FunctionSymbol extends AbstractScopedSymbol {

  private Map<String, VariableSymbol> parameters;

  public FunctionSymbol(Scope enclosing, SourceRange range, String name) {
    super(enclosing, range, name);
    this.parameters = new HashMap<>();
  }

  public void parameter(VariableSymbol symbol) {
    if (symbol == null)
      return;
    final String name = symbol.getName();
    this.parameters.put(name, symbol);
  }

}
