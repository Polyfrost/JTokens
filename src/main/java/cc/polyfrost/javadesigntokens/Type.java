package cc.polyfrost.javadesigntokens;

import cc.polyfrost.javadesigntokens.parsers.compositetypes.ShadowParser;
import cc.polyfrost.javadesigntokens.parsers.compositetypes.TypographyParser;
import cc.polyfrost.javadesigntokens.parsers.json.*;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import cc.polyfrost.javadesigntokens.parsers.type.*;

public enum Type {
    // json objects
    STRING("string", StringParser.INSTANCE),
    NUMBER("number", NumberParser.INSTANCE),
    BOOLEAN("boolean", BooleanParser.INSTANCE),
    OBJECT("object", ObjectParser.INSTANCE),
    ARRAY("array", ArrayParser.INSTANCE),
    // normal objects
    COLOR("color", ColorParser.INSTANCE),
    DIMENSION("dimension", DimensionParser.INSTANCE),
    FONT_FAMILY("fontFamily", FontFamilyParser.INSTANCE),
    FONT_WEIGHT("fontWeight", FontWeightParser.INSTANCE),
    DURATION("duration", DurationParser.INSTANCE),
    CUBIC_BEZIER("cubicBezier", CubicBezierParser.INSTANCE),
    // composite objects
    TYPOGRAPHY("typography", TypographyParser.INSTANCE),
    SHADOW("shadow", ShadowParser.INSTANCE),
    //internal
    UNKNOWN("UNKNOWN_IF_THIS_MATCHES_WEIRD_SHIT_WILL_HAPPEN", null);

    public final String name;

    public final Parser<?> parser;

    Type(String name, Parser<?> parser) {
        this.name = name;
        this.parser = parser;
    }
}
