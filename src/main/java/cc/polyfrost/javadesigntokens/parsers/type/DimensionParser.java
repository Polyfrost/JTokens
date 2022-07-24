package cc.polyfrost.javadesigntokens.parsers.type;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class DimensionParser extends Parser<Float> {
    public static final DimensionParser INSTANCE = new DimensionParser();

    /**
     * Sloppy conversion from rem to pixels since we don't know the default system font size
     *
     * @param rem The rem
     * @return The px
     */
    public float remToPx(float rem) {
        return rem * 16;
    }

    /**
     * Sloppy conversion from pixels to rem since we don't know the default system font size
     *
     * @param px The px
     * @return The rem
     */
    public float pxToRem(float px) {
        return px / 16;
    }

    @Override
    protected Float parseValue(JsonElement element, HashMap<String, Object> values) {
        String value = element.getAsString();
        if (value.endsWith("rem")) {
            return remToPx(Float.parseFloat(value.replace("rem", "")));
        }
        return Float.parseFloat(value.replace("px", ""));
    }
}
