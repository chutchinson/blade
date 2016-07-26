package net.rpgtoolkit.blade.compiler.passes;

import net.rpgtoolkit.blade.compiler.*;

/**
 * Encapsulates the semantic analysis phase of the Blade compiler. This pass performs the
 * following actions:
 *
 * <ul>
 *   <li>Detect common mistakes</li>
 *   <li>Detect duplicate declarations</li>
 *   <li>Detect invalid IR expression trees</li>
 *   <li>Type checking</li>
 * </ul>
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class SemanticAnalysisPass implements CompilerPass {

  private Compilation context;

  @Override
  public void initialize(Compilation context) {
    if (context == null)
      throw new IllegalArgumentException();
    this.context = context;
  }

  @Override
  public void process(Compilation context) throws CompilerException {

  }

}
