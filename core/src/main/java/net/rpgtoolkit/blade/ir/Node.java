/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

import net.rpgtoolkit.blade.ir.symbols.Symbol;

public interface Node {

  Node getParent();

  void setParent(Node node);

  SourceRange getSourceRange();

  NodeAttributeCollection getAttributes();

  Symbol getSymbol();

  void setSymbol(Symbol sym);

  void accept(final NodeVisitor visitor);

}
