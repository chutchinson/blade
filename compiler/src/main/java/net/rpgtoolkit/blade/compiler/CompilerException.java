/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

public class CompilerException extends Exception {

    private final CompilerMessage error;

    public CompilerException(CompilerMessage error) {
        if (error == null)
            throw new IllegalArgumentException();
        this.error = error;
    }

    public int getCode() {
        return this.error.getCode();
    }

    public CompilerMessage getError() {
        return this.error;
    }

    @Override
    public String getMessage() {
        return this.error.getMessage();
    }

}
