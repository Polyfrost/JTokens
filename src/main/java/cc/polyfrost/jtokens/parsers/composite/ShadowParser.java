package cc.polyfrost.jtokens.parsers.composite;

import cc.polyfrost.jtokens.objects.Dimension;
import cc.polyfrost.jtokens.objects.Shadow;
import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.parsers.type.ColorParser;
import cc.polyfrost.jtokens.parsers.type.DimensionParser;
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
        Dimension offsetX = DimensionParser.INSTANCE.parse(object.get("offsetX"), values);
        Dimension offsetY = DimensionParser.INSTANCE.parse(object.get("offsetY"), values);
        Dimension blur = DimensionParser.INSTANCE.parse(object.get("blur"), values);
        Dimension spread = DimensionParser.INSTANCE.parse(object.get("spread"), values);
        return new Shadow(color, offsetX, offsetY, blur, spread);
    }
}
