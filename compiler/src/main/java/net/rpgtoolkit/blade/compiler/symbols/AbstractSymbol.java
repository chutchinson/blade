/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler.symbols;

import net.rpgtoolkit.blade.ir.SourceRange;
import net.rpgtoolkit.blade.ir.symbols.Symbol;

public abstract class AbstractSymbol implements Symbol {

  protected SourceRange range;
  protected String name;

  public AbstractSymbol(SourceRange range, String name) {
    if (range == null || name == null)
      throw new IllegalArgumentException();
    this.range = range;
    this.name = name;
  }

  public SourceRange getSourceRange() {
    return this.range;
  }

  public String getName() {
    return this.name;
  }

}
