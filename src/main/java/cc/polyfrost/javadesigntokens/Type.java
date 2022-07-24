package cc.polyfrost.javadesigntokens;

import cc.polyfrost.javadesigntokens.parsers.composite.*;
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
    // normal types
    COLOR("color", ColorParser.INSTANCE),
    DIMENSION("dimension", DimensionParser.INSTANCE),
    FONT_FAMILY("fontFamily", FontFamilyParser.INSTANCE),
    FONT_WEIGHT("fontWeight", FontWeightParser.INSTANCE),
    DURATION("duration", DurationParser.INSTANCE),
    CUBIC_BEZIER("cubicBezier", CubicBezierParser.INSTANCE),
    // composite types
    TYPOGRAPHY("typography", TypographyParser.INSTANCE),
    SHADOW("shadow", ShadowParser.INSTANCE),
    TRANSITION("transition", TransitionParser.INSTANCE),
    GRADIENT("gradient", GradientParser.INSTANCE),
    STROKE_STYLE("strokeStyle", StrokeStyleParser.INSTANCE),
    //internal
    UNKNOWN("UNKNOWN", null);

    public final String name;

    public final Parser<?> parser;

    Type(String name, Parser<?> parser) {
        this.name = name;
        this.parser = parser;
    }
}
