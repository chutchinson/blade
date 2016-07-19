/**
 * Copyright (c) 2015, rpgtoolkit.net <help@rpgtoolkit.net>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.rpgtoolkit.blade.compiler;

public class CompilerMessage {

    public enum Severity {

        INFO,
        WARNING,
        ERROR,
        FATAL;

    }

    private final Severity severity;
    private final int line;
    private final int column;
    private final int code;
    private final String message;

    public CompilerMessage(Severity severity, int line, int column, int code, String message) {
        if (message ==  null)
            throw new IllegalArgumentException();
        this.severity = severity;
        this.line = line;
        this.column = column;
        this.code = code;
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
        return String.format("(%04d) %s: %s", code, severity, message);
    }

}
