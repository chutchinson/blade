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

}
