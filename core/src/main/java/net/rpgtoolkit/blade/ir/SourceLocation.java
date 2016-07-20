package net.rpgtoolkit.blade.ir;

public class SourceLocation {

    private int line;
    private int column;
    private int offset;

    public SourceLocation(int offset, int line, int column) {
        this.offset = offset;
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return this.line;
    }

    public void setLine(int value) {
        if (value < 0)
            throw new IllegalArgumentException("out of range");
        this.line = value;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int value) {
        if (value < 0)
            throw new IllegalArgumentException("out of range");
        this.column = value;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int value) {
        if (value < 0)
            throw new IllegalArgumentException();
        this.offset = value;
    }

    @Override
    public String toString() {
        return String.format("(%04d, %04d)", this.line, this.column);
    }

}
