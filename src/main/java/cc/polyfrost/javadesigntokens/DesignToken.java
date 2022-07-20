package cc.polyfrost.javadesigntokens;

import java.awt.*;
import java.util.Map;

public class DesignToken {
    private final Map<String, Object> values;

    protected DesignToken(Map<String, Object> values) {
        this.values = values;
    }

    /**
     * @param reference The reference to the design token
     * @return The design token in object form
     */
    public Object getObject(String reference) {
        return values.get(reference);
    }

    /**
     * @param reference The reference to the color token
     * @return The color
     * @throws ClassCastException If the object is not a color
     */
    public Color getColor(String reference) {
        return (Color) getObject(reference);
    }
}
