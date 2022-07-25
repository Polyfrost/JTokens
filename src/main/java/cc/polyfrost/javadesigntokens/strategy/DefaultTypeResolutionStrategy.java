package cc.polyfrost.javadesigntokens.strategy;

import cc.polyfrost.javadesigntokens.parsers.composite.*;
import cc.polyfrost.javadesigntokens.parsers.json.*;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import cc.polyfrost.javadesigntokens.parsers.type.*;

public class DefaultTypeResolutionStrategy implements TypeResolutionStrategy {
    @Override
    public Parser<?> getParser(String type) {
        switch (type) {
            // basic json objects
            case "string":
                return StringParser.INSTANCE;
            case "number":
                return NumberParser.INSTANCE;
            case "boolean":
                return BooleanParser.INSTANCE;
            case "object":
                return ObjectParser.INSTANCE;
            case "array":
                return ArrayParser.INSTANCE;
            // normal types
            case "color":
                return ColorParser.INSTANCE;
            case "dimension":
                return DimensionParser.INSTANCE;
            case "fontFamily":
                return FontFamilyParser.INSTANCE;
            case "fontWeight":
                return FontWeightParser.INSTANCE;
            case "duration":
                return DurationParser.INSTANCE;
            case "cubicBezier":
                return CubicBezierParser.INSTANCE;
            // composite types
            case "typography":
                return TypographyParser.INSTANCE;
            case "shadow":
                return ShadowParser.INSTANCE;
            case "transition":
                return TransitionParser.INSTANCE;
            case "gradient":
                return GradientParser.INSTANCE;
            case "strokeStyle":
                return StrokeStyleParser.INSTANCE;
            case "border":
                return BorderParser.INSTANCE;
        }
        return null;
    }
}
