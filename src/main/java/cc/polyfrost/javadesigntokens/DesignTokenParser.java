package cc.polyfrost.javadesigntokens;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.Reader;

public class DesignTokenParser {
    private static final JsonParser PARSER = new JsonParser();

    /**
     * Parse a json object to a design token
     *
     * @param object The json object
     * @return The design token
     */
    public static DesignToken parseJsonObject(JsonObject object) {
    }

    /**
     * Parse a json string to a design token
     *
     * @param json The json
     * @return The design token
     */
    public static DesignToken parseString(String json) {
        return parseJsonObject(PARSER.parse(json).getAsJsonObject());
    }

    /**
     * Parse a reader to a design token
     *
     * @param reader The reader
     * @return The design token
     */
    public static DesignToken parseReader(Reader reader) {
        return parseJsonObject(PARSER.parse(reader).getAsJsonObject());
    }

    /**
     * Parse a json reader to a design token
     *
     * @param reader The json reader
     * @return The design token
     */
    public static DesignToken parseReader(JsonReader reader) {
        return parseJsonObject(PARSER.parse(reader).getAsJsonObject());
    }
}
