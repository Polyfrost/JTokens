package cc.polyfrost.javadesigntokens.parsers.composite;

import cc.polyfrost.javadesigntokens.objects.Border;
import cc.polyfrost.javadesigntokens.objects.Dimension;
import cc.polyfrost.javadesigntokens.objects.StrokeStyle;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import cc.polyfrost.javadesigntokens.parsers.type.ColorParser;
import cc.polyfrost.javadesigntokens.parsers.type.DimensionParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;
import java.util.HashMap;

public class BorderParser extends Parser<Border> {
    public static final BorderParser INSTANCE = new BorderParser();

    @Override
    protected Border parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonObject object = element.getAsJsonObject();
        Color color = ColorParser.INSTANCE.parse(object.get("color"), values);
        Dimension width = DimensionParser.INSTANCE.parse(object.get("width"), values);
        StrokeStyle strokeStyle = StrokeStyleParser.INSTANCE.parse(object.get("style"), values);
        return new Border(color, width, strokeStyle);
    }
}
