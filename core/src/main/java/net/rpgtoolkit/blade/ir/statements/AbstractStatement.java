/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir.statements;

import net.rpgtoolkit.blade.ir.AbstractNode;
import net.rpgtoolkit.blade.ir.SourceRange;
import net.rpgtoolkit.blade.ir.Statement;

public abstract class AbstractStatement extends AbstractNode implements Statement {

  public AbstractStatement(SourceRange range) {
    super(range);
  }

}
