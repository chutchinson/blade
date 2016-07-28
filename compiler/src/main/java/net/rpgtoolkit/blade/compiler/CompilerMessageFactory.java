/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

import net.rpgtoolkit.blade.ir.SourceLocation;
import net.rpgtoolkit.blade.ir.SourceRange;

/**
 * Encapsulates factory methods for constructing compiler messages.
 *
 * @see CompilerMessage
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class CompilerMessageFactory {

  public static CompilerMessage error(int code, SourceRange range, String format, Object... args) {
    final SourceLocation loc = range.getStartLocation();
    return new CompilerMessage(CompilerMessage.Severity.ERROR, code, loc.getLine(), loc.getColumn(),
        String.format(format, args));
  }

  public static CompilerMessage warn(int code, SourceRange range, String format, Object... args) {
    final SourceLocation loc = range.getStartLocation();
    return new CompilerMessage(CompilerMessage.Severity.WARNING, code, loc.getLine(), loc.getColumn(),
        String.format(format, args));
  }

}
