/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.ir;

public class SourceLocation implements Cloneable {

  private int line;
  private int column;
  private int offset;

  public SourceLocation(int offset, int line, int column) {
    this.offset = offset;
    this.line = line;
    this.column = column;
  }

  public int getLine() {
    return this.line;
  }

  public void setLine(int value) {
    if (value < 0)
      throw new IllegalArgumentException("out of range");
    this.line = value;
  }

  public int getColumn() {
    return this.column;
  }

  public void setColumn(int value) {
    if (value < 0)
      throw new IllegalArgumentException("out of range");
    this.column = value;
  }

  public int getOffset() {
    return this.offset;
  }

  public void setOffset(int value) {
    if (value < 0)
      throw new IllegalArgumentException();
    this.offset = value;
  }

  @Override
  public String toString() {
    return String.format("(%04d, %04d)", this.line, this.column);
  }

  @Override
  public Object clone() {
    return new SourceLocation(this.offset, this.line, this.column);
  }

}
