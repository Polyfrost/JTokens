package cc.polyfrost.jtokens.parsers.composite;

import cc.polyfrost.jtokens.objects.Border;
import cc.polyfrost.jtokens.objects.Dimension;
import cc.polyfrost.jtokens.objects.StrokeStyle;
import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.parsers.type.ColorParser;
import cc.polyfrost.jtokens.parsers.type.DimensionParser;
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
