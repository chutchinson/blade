package net.rpgtoolkit.blade.compiler;

public class CompilerError {

    private final int code;
    private final String message;

    public CompilerError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return String.format("(%04d) %s", code, message);
    }

}
