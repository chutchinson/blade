/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler.attributes;

import net.rpgtoolkit.blade.ir.attributes.NodeAttribute;

/**
 * Node attribute for identifying a node as containing unreachable code. A reason can be
 * supplied to explain the unreachable condition.
 */
public class UnreachableCodeAttribute implements NodeAttribute {

  public enum Reason {
    UNSPECIFIED,
    FOLLOWS_RETURN,
    UNNESTED
  }

  public static final int ID = 1078557986;

  private final Reason reason;

  public UnreachableCodeAttribute(Reason reason) {
    this.reason = reason;
  }

  @Override
  public int getId() {
    return ID;
  }

  public Reason getReason() {
    return this.reason;
  }

}
