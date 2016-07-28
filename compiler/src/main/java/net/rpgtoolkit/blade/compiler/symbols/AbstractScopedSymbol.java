/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
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
