package net.rpgtoolkit.blade.ir;

public class SourceRange {

    private SourceLocation start;
    private SourceLocation end;

    public static SourceRange build(SourceLocation start, SourceLocation end) {
        return new SourceRange(start, end);
    }

    public SourceRange(SourceLocation start, SourceLocation end) {
        this.setStartLocation(start);
        this.setEndLocation(end);
    }

    public SourceLocation getStartLocation() {
        return this.start;
    }

    public final void setStartLocation(SourceLocation location) {
        if (location == null)
            throw new IllegalArgumentException();
        this.start = location;
    }

    public SourceLocation getEndLocation() {
        return this.end;
    }

    public final void setEndLocation(SourceLocation location) {
        if (location == null)
            throw new IllegalArgumentException();
        this.end = location;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d) : (%d, %d)", 0, 0, 0, 0);
    }

}
