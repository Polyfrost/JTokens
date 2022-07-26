package cc.polyfrost.jtokens.parsers.composite;

import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.parsers.json.NumberParser;
import cc.polyfrost.jtokens.parsers.type.ColorParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;
import java.util.HashMap;

public class GradientParser extends Parser<HashMap<Float, Color>> {
    public static final GradientParser INSTANCE = new GradientParser();

    @Override
    protected HashMap<Float, Color> parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonArray array = element.getAsJsonArray();
        HashMap<Float, Color> gradient = new HashMap<>();
        for (JsonElement element1 : array) {
            JsonObject object = element1.getAsJsonObject();
            Color color = ColorParser.INSTANCE.parse(object.get("color"), values);
            float position = NumberParser.INSTANCE.parse(object.get("position"), values);
            position = position < 0f ? 0f : Math.min(position, 1f);
            gradient.put(position, color);
        }
        return gradient;
    }
}
