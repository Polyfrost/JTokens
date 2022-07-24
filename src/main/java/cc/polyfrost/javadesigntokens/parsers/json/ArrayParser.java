package cc.polyfrost.javadesigntokens.parsers.json;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class ArrayParser extends Parser<JsonArray> {
    public static final ArrayParser INSTANCE = new ArrayParser();

    @Override
    protected JsonArray parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsJsonArray();
    }
}
