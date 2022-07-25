package cc.polyfrost.javadesigntokens.parsers.type;

import cc.polyfrost.javadesigntokens.objects.Dimension;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class DimensionParser extends Parser<Dimension> {
    public static final DimensionParser INSTANCE = new DimensionParser();

    @Override
    protected Dimension parseValue(JsonElement element, HashMap<String, Object> values) {
        String value = element.getAsString();
        if (value.endsWith("rem")) {
            return new Dimension(Dimension.Unit.REM, Float.parseFloat(value.replace("rem", "")));
        }
        return new Dimension(Dimension.Unit.PX, Float.parseFloat(value.replace("px", "")));
    }
}
