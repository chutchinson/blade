/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

/**
 * Compilation mode that affects compiler analysis and code generation.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public enum CompilationMode {

  /**
   * Constant that informs the compiler to infer the compilation mode.
   */
  AUTO,

  /**
   * Enables legacy compilation for archaic programs.
   */
  LEGACY,

  /**
   * Enables experimental compiler features.
   */
  EXPERIMENTAL

}
