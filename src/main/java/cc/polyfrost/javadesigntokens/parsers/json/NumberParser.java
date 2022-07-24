package cc.polyfrost.javadesigntokens.parsers.json;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class NumberParser extends Parser<Float> {
    public static final NumberParser INSTANCE = new NumberParser();

    @Override
    protected Float parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsFloat();
    }
}
