package cc.polyfrost.jtokens;

import cc.polyfrost.jtokens.exceptions.UnresolvedReferenceException;
import cc.polyfrost.jtokens.objects.*;
import cc.polyfrost.jtokens.objects.Dimension;
import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.strategy.DefaultTypeResolutionStrategy;
import cc.polyfrost.jtokens.strategy.TypeResolutionStrategy;
import cc.polyfrost.jtokens.utils.JsonHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.awt.*;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class DesignToken {
    private static final int maxReferenceDepth = 25;
    private final TypeResolutionStrategy resolutionStrategy;
    private final HashMap<String, Object> values = new HashMap<>();
    private final HashMap<String, JsonElement> extensions = new HashMap<>();
    private boolean resolved = false;

    /**
     * Parse a json object to a design token
     *
     * @param resolutionStrategy A custom strategy resolution strategy, allows for creating your own custom types
     * @param objects            The json objects, first object has the highest priority for duplicate tokens
     */
    public DesignToken(TypeResolutionStrategy resolutionStrategy, JsonObject... objects) {
        this.resolutionStrategy = resolutionStrategy;
        int depth = 0;
        while (!resolved && depth < maxReferenceDepth) {
            resolved = true;
            for (JsonObject object : objects) {
                parsePart(object, "UNKNOWN", "");
            }
            depth++;
        }
        if (!resolved) System.err.println("(JTokens) ERROR: Unable to resolve all references!");
    }

    /**
     * Parse a json object to a design token
     *
     * @param objects The json objects, first object has the highest priority for duplicate tokens
     */
    public DesignToken(JsonObject... objects) {
        this(new DefaultTypeResolutionStrategy(), objects);
    }

    /**
     * Parse a json string to a design token
     *
     * @param resolutionStrategy A custom strategy resolution strategy, allows for creating your own custom types
     * @param json               The json, first object has the highest priority for duplicate tokens
     */
    public DesignToken(TypeResolutionStrategy resolutionStrategy, String... json) {
        this(resolutionStrategy, JsonHelper.getJsonObjects(json));
    }

    /**
     * Parse a json string to a design token
     *
     * @param json The json, first object has the highest priority for duplicate tokens
     */
    public DesignToken(String... json) {
        this(JsonHelper.getJsonObjects(json));
    }

    /**
     * Parse a json string to a design token
     *
     * @param resolutionStrategy A custom strategy resolution strategy, allows for creating your own custom types
     * @param json               The json, first object has the highest priority for duplicate tokens
     */
    public DesignToken(TypeResolutionStrategy resolutionStrategy, Reader... json) {
        this(resolutionStrategy, JsonHelper.getJsonObjects(json));
    }

    /**
     * Parse a reader to a design token
     *
     * @param readers The readers, first object has the highest priority for duplicate tokens
     */
    public DesignToken(Reader... readers) {
        this(JsonHelper.getJsonObjects(readers));
    }

    /**
     * Parse a json string to a design token
     *
     * @param resolutionStrategy A custom strategy resolution strategy, allows for creating your own custom types
     * @param json               The json, first object has the highest priority for duplicate tokens
     */
    public DesignToken(TypeResolutionStrategy resolutionStrategy, JsonReader... json) {
        this(resolutionStrategy, JsonHelper.getJsonObjects(json));
    }

    /**
     * Parse a json reader to a design token
     *
     * @param readers The json readers, first object has the highest priority for duplicate tokens
     */
    public DesignToken(JsonReader... readers) {
        this(JsonHelper.getJsonObjects(readers));
    }

    private void parsePart(JsonObject object, String type, String path) {
        if (object.has("$type")) type = object.get("$type").getAsString();
        if (object.has("$value") && !values.containsKey(path)) {
            JsonElement element = object.get("$value");
            if (element.isJsonPrimitive() && element.getAsString().startsWith("{") && element.getAsString().endsWith("}")) {
                String reference = element.getAsString();
                reference = reference.substring(1, reference.length() - 1);
                if (values.containsKey(reference)) values.put(path, values.get(reference));
                else resolved = false;
            } else {
                try {
                    values.put(path, getValue(element, type));
                } catch (UnresolvedReferenceException e) {
                    resolved = false;
                }
            }
        }
        if (object.has("$extensions") && !extensions.containsKey(path))
            extensions.put(path, object.get("$extensions"));
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            String name = entry.getKey();
            JsonElement value = entry.getValue();
            if (name.startsWith("$") || !value.isJsonObject()) continue;
            String newPath = path + (path.equals("") ? "" : ".") + name;
            parsePart(value.getAsJsonObject(), type, newPath);
        }
    }

    private Object getValue(JsonElement element, String type) {
        Parser<?> parser = resolutionStrategy.getParser(type);
        if (parser == null) return element;
        return parser.parse(element, values);
    }

    @Override
    public String toString() {
        return values.toString();
    }

    /**
     * @param reference The reference to the design token
     * @return If it has the design token
     */
    public boolean has(String reference) {
        return values.containsKey(reference);
    }

    /**
     * @param reference The reference to the design token
     * @return The design token in object form
     */
    public Object get(String reference) {
        return values.get(reference);
    }

    /**
     * @param reference The reference to the string token
     * @return The string
     * @throws ClassCastException If the object is not a string
     */
    public String getString(String reference) {
        return (String) get(reference);
    }

    /**
     * @param reference The reference to the number token
     * @return The float
     * @throws ClassCastException If the object is not a float
     */
    public float getFloat(String reference) {
        return (float) get(reference);
    }

    /**
     * @param reference The reference to the boolean token
     * @return The boolean
     * @throws ClassCastException If the object is not a boolean
     */
    public boolean getBoolean(String reference) {
        return (boolean) get(reference);
    }

    /**
     * @param reference The reference to the object token
     * @return The object
     * @throws ClassCastException If the object is not a (json) object
     */
    public JsonObject getObject(String reference) {
        return (JsonObject) get(reference);
    }

    /**
     * @param reference The reference to the array token
     * @return The array
     * @throws ClassCastException If the object is not a (json) array
     */
    public JsonArray getArray(String reference) {
        return (JsonArray) get(reference);
    }

    /**
     * @param reference The reference to the color token
     * @return The color
     * @throws ClassCastException If the object is not a color
     */
    public Color getColor(String reference) {
        return (Color) get(reference);
    }

    /**
     * @param reference The reference to the font family token
     * @return The font family
     * @throws ClassCastException If the object is not a font family
     */
    public String[] getFontFamily(String reference) {
        return (String[]) get(reference);
    }

    /**
     * @param reference The reference to the font weight
     * @return The font weight
     * @throws ClassCastException If the object is not a font weight
     */
    public int getFontWeight(String reference) {
        return (int) get(reference);
    }

    /**
     * @param reference The reference to the dimension
     * @return The dimension in pixels
     * @throws ClassCastException If the object is not a dimension
     */
    public Dimension getDimension(String reference) {
        return (Dimension) get(reference);
    }

    /**
     * @param reference The reference to the duration
     * @return The duration in milliseconds
     * @throws ClassCastException If the object is not a duration
     */
    public float getDuration(String reference) {
        return (float) get(reference);
    }

    /**
     * @param reference The reference to the cubic bezier
     * @return The cubic bezier
     * @throws ClassCastException If the object is not a cubic bezier
     */
    public float[] getCubicBezier(String reference) {
        return (float[]) get(reference);
    }

    /**
     * @param reference The reference to the typography object
     * @return The typography object
     * @throws ClassCastException If the object is not a typography object
     */
    public Typography getTypography(String reference) {
        return (Typography) get(reference);
    }

    /**
     * @param reference The reference to the shadow object
     * @return The shadow object
     * @throws ClassCastException If the object is not a shadow object
     */
    public Shadow getShadow(String reference) {
        return (Shadow) get(reference);
    }

    /**
     * @param reference The reference to the transition object
     * @return The transition object
     * @throws ClassCastException If the object is not a transition object
     */
    public Transition getTransition(String reference) {
        return (Transition) get(reference);
    }

    /**
     * @param reference The reference to the gradient
     * @return The gradient, the keys are the positions and the values are the colors
     * @throws ClassCastException If the object is not a gradient
     */
    public HashMap<Float, Color> getGradient(String reference) {
        return (HashMap<Float, Color>) get(reference);
    }

    /**
     * @param reference The reference to the stroke style
     * @return The stroke style object
     * @throws ClassCastException If the object is not a stroke style
     */
    public StrokeStyle getStrokeStyle(String reference) {
        return (StrokeStyle) get(reference);
    }

    /**
     * @param reference The reference to the border
     * @return The border object
     * @throws ClassCastException If the object is not a border
     */
    public Border getBorder(String reference) {
        return (Border) get(reference);
    }

    /**
     * @param reference The reference to an extension
     * @return If the extension exists
     */
    public boolean hasExtension(String reference) {
        return extensions.containsKey(reference);
    }

    /**
     * @param reference The reference to an extension
     * @return The extension
     */
    public JsonElement getExtension(String reference) {
        return extensions.get(reference);
    }
}
