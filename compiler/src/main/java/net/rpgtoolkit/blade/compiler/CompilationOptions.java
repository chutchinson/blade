/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

/**
 * Collection of compiler options that affect the method in which the compiler
 * performs analysis, presents messages, generates code, and various other
 * activities.
 *
 * @author Chris Hutchinson
 * @since 4.0.0
 */
public class CompilationOptions {

    private boolean autolocal;
    private CompilationMode mode;

    public CompilationOptions() {
        this.autolocal = false;
        this.mode = CompilationMode.AUTO;
    }

    public boolean getIsAutoLocalEnabled() {
        return this.autolocal;
    }

    public void setIsAutoLocalEnabled(boolean value) {
        this.autolocal = value;
    }

    public CompilationMode getMode() {
        return this.mode;
    }

    public void setMode(CompilationMode mode) {
        this.mode = mode;
    }

    public static CompilationOptions getDefaults() {
        final CompilationOptions options = new CompilationOptions();
        options.setIsAutoLocalEnabled(false);
        options.setMode(CompilationMode.AUTO);
        return options;
    }

}
