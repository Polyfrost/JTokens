package cc.polyfrost.javadesigntokens.parsers.type;

import cc.polyfrost.javadesigntokens.parsers.Parser;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;

public class FontWeightParser extends Parser<Integer> {
    public static final FontWeightParser INSTANCE = new FontWeightParser();

    private static final HashMap<String, Integer> weights = new HashMap<String, Integer>() {{
        put("thin", 100);
        put("hairline", 100);
        put("extra-light", 200);
        put("ultra-light", 200);
        put("light", 300);
        put("normal", 400);
        put("regular", 400);
        put("book", 400);
        put("medium", 500);
        put("semi-bold", 600);
        put("demi-bold", 600);
        put("bold", 700);
        put("extra-bold", 800);
        put("ultra-bold", 800);
        put("black", 900);
        put("heavy", 900);
        put("extra-black", 950);
        put("ultra-black", 950);
    }};

    /**
     * Get the weight number associated with a name
     *
     * @param name The name
     * @return The weight number
     */
    public int getFontWeightNumber(String name) {
        return weights.get(name);
    }

    /**
     * Get a name associated with a weight number
     *
     * @param number The number
     * @return The name
     */
    public String getFontWeightName(int number) {
        for (String name : weights.keySet()) {
            if (weights.get(name) == number) return name;
        }
        return null;
    }

    @Override
    protected Integer parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonPrimitive primitive = element.getAsJsonPrimitive();
        if (primitive.isNumber()) {
            int value = primitive.getAsInt();
            if (value < 1 || value > 1000) throw new IllegalArgumentException("Font weight must be in range [1, 1000]!");
            return value;
        }
        return getFontWeightNumber(primitive.getAsString());
    }
}
