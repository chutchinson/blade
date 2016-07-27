/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

/**
 * A user-friendly compiler message issued during compilation.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class CompilerMessage {

  /**
   * Severity (importance) of the compiler message.
   */
  public enum Severity {

    INFO,
    WARNING,
    ERROR,
    FATAL;

  }

  private final Severity severity;
  private final int code;
  private final int line;
  private final int column;
  private final String message;

  public CompilerMessage(Severity severity, int code, int line, int column, String message) {
    if (message == null)
      throw new IllegalArgumentException();
    this.severity = severity;
    this.code = code;
    this.line = line;
    this.column = column;
    this.message = message;
  }

  public Severity getSeverity() {
    return this.severity;
  }

  public int getLine() {
    return this.line;
  }

  public int getColumn() {
    return this.column;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  @Override
  public String toString() {
    return String.format("(%04d, %04d) %s %04d: %s", line, column, severity, code, message);
  }

}
