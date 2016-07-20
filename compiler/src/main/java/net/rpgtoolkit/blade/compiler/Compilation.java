/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

import net.rpgtoolkit.blade.ir.CompilationUnit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Compilation {

    private final BladeCompiler compiler;
    private final CompilationOptions options;
    private final CompilationUnit unit;
    private final List<CompilerMessage> messages;

    public Compilation(BladeCompiler compiler, CompilationOptions options, CompilationUnit unit) {
        if (compiler == null)
            throw new IllegalArgumentException();
        if (unit == null)
            throw new IllegalArgumentException();
        this.compiler = compiler;
        this.options = (options != null) ? options : CompilationOptions.getDefaults();
        this.messages = new ArrayList<>();
        this.unit = unit;
    }

    public Collection<CompilerMessage> getMessages() {
        return this.messages;
    }

    public BladeCompiler getCompiler() {
        return this.compiler;
    }

    public CompilationUnit getCompilationUnit() {
        return this.unit;
    }

    public CompilationOptions getOptions() {
        return this.options;
    }

    public void message(CompilerMessage msg) {
        if (msg == null)
            throw new IllegalArgumentException();
        this.messages.add(msg);
    }

}
