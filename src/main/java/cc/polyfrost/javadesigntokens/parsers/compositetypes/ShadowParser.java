package cc.polyfrost.javadesigntokens.parsers.compositetypes;

import cc.polyfrost.javadesigntokens.objects.Shadow;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import cc.polyfrost.javadesigntokens.parsers.type.ColorParser;
import cc.polyfrost.javadesigntokens.parsers.type.DimensionParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;
import java.util.HashMap;

public class ShadowParser extends Parser<Shadow> {
    public static final ShadowParser INSTANCE = new ShadowParser();

    @Override
    protected Shadow parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonObject object = element.getAsJsonObject();
        Color color = ColorParser.INSTANCE.parse(object.get("color"), values);
        float offsetX = DimensionParser.INSTANCE.parse(object.get("offsetX"), values);
        float offsetY = DimensionParser.INSTANCE.parse(object.get("offsetY"), values);
        float blur = DimensionParser.INSTANCE.parse(object.get("blur"), values);
        float spread = DimensionParser.INSTANCE.parse(object.get("spread"), values);
        return new Shadow(color, offsetX, offsetY, blur, spread);
    }
}
