package cc.polyfrost.jtokens.parsers.composite;

import cc.polyfrost.jtokens.objects.Dimension;
import cc.polyfrost.jtokens.objects.StrokeStyle;
import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.parsers.json.ArrayParser;
import cc.polyfrost.jtokens.parsers.json.StringParser;
import cc.polyfrost.jtokens.parsers.type.DimensionParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class StrokeStyleParser extends Parser<StrokeStyle> {
    public static final StrokeStyleParser INSTANCE = new StrokeStyleParser();

    @Override
    protected StrokeStyle parseValue(JsonElement element, HashMap<String, Object> values) {
        if (element.isJsonPrimitive()) {
            String value = element.getAsString();
            for (StrokeStyle.Style style : StrokeStyle.Style.values()) {
                if (!style.name.equals(value)) continue;
                return new StrokeStyle(style);
            }
            throw new IllegalArgumentException(value + " is not an allowed stroke type!");
        }
        JsonObject object = element.getAsJsonObject();
        JsonArray array = ArrayParser.INSTANCE.parse(object.get("dashArray"), values);
        String lineCap = StringParser.INSTANCE.parse(object.get("lineCap"), values);
        Dimension[] dashArray = new Dimension[array.size()];
        for (int i = 0; i < array.size(); i++) dashArray[i] = DimensionParser.INSTANCE.parse(array.get(i), values);
        for (StrokeStyle.LineCap cap : StrokeStyle.LineCap.values()) {
            if (!cap.name.equals(lineCap)) continue;
            return new StrokeStyle(dashArray, cap);
        }
        throw new IllegalArgumentException(lineCap + " is not an allowed line cap!");
    }
}
