package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.compiler.Scope;
import net.rpgtoolkit.blade.ir.SourceRange;

public abstract class AbstractScopedSymbol
    extends AbstractSymbol implements ScopedSymbol {

  private final Scope scope;

  public AbstractScopedSymbol(Scope enclosing, SourceRange range, String name) {
    super(range, name);
    this.scope = new Scope(enclosing);
  }

  public Scope getScope() {
    return this.scope;
  }

}
