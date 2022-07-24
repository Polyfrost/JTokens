package cc.polyfrost.javadesigntokens.parsers.json;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class ObjectParser extends Parser<JsonObject> {
    public static final ObjectParser INSTANCE = new ObjectParser();

    @Override
    protected JsonObject parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsJsonObject();
    }
}
