package cc.polyfrost.javadesigntokens.parsers.type;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class DurationParser extends Parser<Float> {
    public static final DurationParser INSTANCE = new DurationParser();

    @Override
    protected Float parseValue(JsonElement element, HashMap<String, Object> values) {
        return Float.parseFloat(element.getAsString().replace("ms", ""));
    }
}
