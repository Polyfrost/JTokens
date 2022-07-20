package cc.polyfrost.javadesigntokens.helpers;

import java.util.HashMap;

public class FontWeightHelper {
    private static final HashMap<String, Integer> weights = new HashMap<String, Integer>() {{
        put("thing", 100);
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
    public static int getFontWeightNumber(String name) {
        return weights.get(name);
    }

    /**
     * Get a name associated with a weight number
     *
     * @param number The number
     * @return The name
     */
    public static String getFontWeightName(int number) {
        for (String name : weights.keySet()) {
            if (weights.get(name) == number) return name;
        }
        return null;
    }
}
