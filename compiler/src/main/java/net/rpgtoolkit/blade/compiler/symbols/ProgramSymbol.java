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
