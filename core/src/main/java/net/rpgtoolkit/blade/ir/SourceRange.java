/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 * <p>
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class SourceRange {

  private SourceLocation start;
  private SourceLocation end;

  public static SourceRange build(SourceLocation start, SourceLocation end) {
    return new SourceRange(start, end);
  }

  public SourceRange(SourceLocation start, SourceLocation end) {
    this.setStartLocation(start);
    this.setEndLocation(end);
  }

  public SourceLocation getStartLocation() {
    return this.start;
  }

  public final void setStartLocation(SourceLocation location) {
    if (location == null)
      throw new IllegalArgumentException();
    this.start = location;
  }

  public SourceLocation getEndLocation() {
    return this.end;
  }

  public final void setEndLocation(SourceLocation location) {
    if (location == null)
      throw new IllegalArgumentException();
    this.end = location;
  }

  @Override
  public String toString() {
    return String.format("(%d, %d) : (%d, %d)",
        start.getLine(), start.getColumn(), end.getLine(), end.getColumn());
  }

}
