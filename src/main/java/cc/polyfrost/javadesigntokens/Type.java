package cc.polyfrost.javadesigntokens;

public enum Type {
    COLOR("color"),
    DIMENSION("dimension"),
    FONT_FAMILY("fontFamily"),
    FONT_WEIGHT("fontWeight"),
    DURATION("duration"),
    CUBIC_BEZIER("cubicBezier"),
    UNKNOWN("UNKNOWN_IF_THIS_MATCHES_WEIRD_SHIT_WILL_HAPPEN");

    public final String name;

    Type(String name) {
        this.name = name;
    }
}
