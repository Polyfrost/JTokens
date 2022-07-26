package cc.polyfrost.jtokens.parsers.type;

import cc.polyfrost.jtokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.awt.*;
import java.util.HashMap;

public class ColorParser extends Parser<Color> {
    public static final ColorParser INSTANCE = new ColorParser();

    public Color hexToRGB(String colorStr) {
        return new java.awt.Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }

    @Override
    protected Color parseValue(JsonElement element, HashMap<String, Object> values) {
        return hexToRGB(element.getAsString());
    }
}
