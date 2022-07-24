package cc.polyfrost.javadesigntokens.parsers.type;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class FontFamilyParser extends Parser<String[]> {
    public static final FontFamilyParser INSTANCE = new FontFamilyParser();

    @Override
    protected String[] parseValue(JsonElement element, HashMap<String, Object> values) {
        if (element.isJsonPrimitive()) return new String[]{element.getAsString()};
        JsonArray array = element.getAsJsonArray();
        String[] fonts = new String[array.size()];
        for (int i = 0; i < array.size(); i++) fonts[i] = array.get(i).getAsString();
        return fonts;
    }
}
