package cc.polyfrost.javadesigntokens;

public enum Types {
    COLOR("color"),
    DIMENSION("dimension"),
    FONT_FAMILY("fontFamily"),
    FONT_WEIGHT("fontWeight"),
    DURATION("duration"),
    CUBIC_BEZIER("cubicBezier"),
    UNKNOWN("");

    public final String name;

    Types(String name) {
        this.name = name;
    }
}
