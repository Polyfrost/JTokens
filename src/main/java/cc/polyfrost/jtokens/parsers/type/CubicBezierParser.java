package cc.polyfrost.jtokens.parsers.type;

import cc.polyfrost.jtokens.parsers.Parser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class CubicBezierParser extends Parser<float[]> {
    public static final CubicBezierParser INSTANCE = new CubicBezierParser();

    @Override
    protected float[] parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonArray jsonArray = element.getAsJsonArray();
        return new float[]{
                jsonArray.get(0).getAsFloat(), jsonArray.get(1).getAsFloat(),
                jsonArray.get(2).getAsFloat(), jsonArray.get(3).getAsFloat()
        };
    }
}
