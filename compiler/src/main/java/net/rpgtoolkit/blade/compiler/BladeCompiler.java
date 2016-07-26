/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

import net.rpgtoolkit.blade.compiler.passes.SemanticAnalysisPass;
import net.rpgtoolkit.blade.ir.CompilationUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * The Blade module compiler. The compiler takes an intermediate representation (IR) generated
 * by a language parser, performs semantic and logic analysis, and generates a Blade module, which
 * is a program executable by a virtual machine.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class BladeCompiler {

  private final List<CompilerPass> passes;

  public BladeCompiler() {
    this.passes = new ArrayList<>();
    this.initialize();
  }

  public Compilation compile(CompilationOptions options, CompilationUnit unit)
      throws CompilerException {

    final Compilation compilation = new Compilation(this, options, unit);

    for (final CompilerPass pass : passes) {
      pass.initialize(compilation);
      pass.process(compilation);
      if (compilation.hasErrors())
        break;
    }

    return compilation;

  }

  public void log(String message) {
    System.out.println(message);
  }

  private final void initialize() {
    passes.add(new SemanticAnalysisPass());
  }

}
