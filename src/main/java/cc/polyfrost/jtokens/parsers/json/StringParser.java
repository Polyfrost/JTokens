package cc.polyfrost.jtokens.parsers.json;

import cc.polyfrost.jtokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class StringParser extends Parser<String> {
    public static final StringParser INSTANCE = new StringParser();

    @Override
    protected String parseValue(JsonElement element, HashMap<String, Object> values) {
        return element.getAsString();
    }
}
