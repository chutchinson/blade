package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.compiler.Scope;
import net.rpgtoolkit.blade.ir.SourceRange;

public abstract class AbstractScopedSymbol
    extends AbstractSymbol implements ScopedSymbol {

  private Scope scope;

  public AbstractScopedSymbol(SourceRange range, String name) {
    super(range, name);
  }

  public Scope getScope() {
    return this.scope;
  }

  public void setScope(Scope scope) {
    this.scope = scope;
  }

}
