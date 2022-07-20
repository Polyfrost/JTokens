package cc.polyfrost.javadesigntokens;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.awt.*;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class DesignToken {
    private static final JsonParser PARSER = new JsonParser();
    private final HashMap<String, Object> values = new HashMap<>();

    /**
     * Parse a json object to a design token
     *
     * @param object The json object
     */
    public DesignToken(JsonObject object) {
        parsePart(object, Type.UNKNOWN, "");
    }

    /**
     * Parse a json string to a design token
     *
     * @param json The json
     */
    public DesignToken(String json) {
        this(PARSER.parse(json).getAsJsonObject());
    }

    /**
     * Parse a reader to a design token
     *
     * @param reader The reader
     */
    public DesignToken(Reader reader) {
        this(PARSER.parse(reader).getAsJsonObject());
    }

    /**
     * Parse a json reader to a design token
     *
     * @param reader The json reader
     */
    public DesignToken(JsonReader reader) {
        this(PARSER.parse(reader).getAsJsonObject());
    }

    private void parsePart(JsonObject object, Type type, String path) {
        if (object.has("$type")) {
            String typeValue = object.get("$type").getAsString();
            for (Type type1 : Type.values()) {
                if (!type1.name.equals(typeValue)) continue;
                type = type1;
                break;
            }
        }
        if (object.has("$value")) {
            values.put(path, getValue(object.get("$value"), type));
            return;
        }
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            String name = entry.getKey();
            JsonElement value = entry.getValue();
            if (name.startsWith("$") || !value.isJsonObject()) continue;
            String newPath = path + (path.equals("") ? "" : ".") + name;
            parsePart(value.getAsJsonObject(), type, newPath);
        }
    }

    private Object getValue(JsonElement jsonElement, Type type) {
        switch (type) {
            case COLOR:
                return hexToRGB(jsonElement.getAsString());
            default:
                return jsonElement;
        }
    }

    private Color hexToRGB(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
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
     * @param reference The reference to the design token
     * @return If the design token is a color
     */
    public boolean isColor(String reference) {
        return get(reference) instanceof Color;
    }

    /**
     * @param reference The reference to the color token
     * @return The color
     * @throws ClassCastException If the object is not a color
     */
    public Color getColor(String reference) {
        return (Color) get(reference);
    }
}
