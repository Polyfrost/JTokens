package cc.polyfrost.jtokens.parsers.json;

import cc.polyfrost.jtokens.parsers.Parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class ArrayParser extends Parser<JsonArray> {
    public static final ArrayParser INSTANCE = new ArrayParser();

    @Override
    protected JsonArray parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsJsonArray();
    }
}
