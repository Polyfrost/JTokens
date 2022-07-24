package cc.polyfrost.javadesigntokens.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.Reader;

public class JsonHelper {
    private static final JsonParser PARSER = new JsonParser();

    /**
     * @param json The json strings
     * @return an array of json objects
     */
    public static JsonObject[] getJsonObjects(String... json) {
        JsonObject[] objects = new JsonObject[json.length];
        for(int i = 0; i < objects.length; i++) {
            objects[i] = PARSER.parse(json[i]).getAsJsonObject();
        }
        return objects;
    }

    /**
     * @param readers The readers
     * @return an array of json objects
     */
    public static JsonObject[] getJsonObjects(Reader... readers) {
        JsonObject[] objects = new JsonObject[readers.length];
        for(int i = 0; i < objects.length; i++) {
            objects[i] = PARSER.parse(readers[i]).getAsJsonObject();
        }
        return objects;
    }

    /**
     * @param readers The json readers
     * @return an array of json objects
     */
    public static JsonObject[] getJsonObjects(JsonReader... readers) {
        JsonObject[] objects = new JsonObject[readers.length];
        for(int i = 0; i < objects.length; i++) {
            objects[i] = PARSER.parse(readers[i]).getAsJsonObject();
        }
        return objects;
    }
}
