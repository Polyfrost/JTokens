package cc.polyfrost.javadesigntokens.parsers.json;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class BooleanParser extends Parser<Boolean> {
    public static final BooleanParser INSTANCE = new BooleanParser();

    @Override
    protected Boolean parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsBoolean();
    }
}
