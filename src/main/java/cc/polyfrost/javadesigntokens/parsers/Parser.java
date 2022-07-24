package cc.polyfrost.javadesigntokens.parsers;

import cc.polyfrost.javadesigntokens.exceptions.UnresolvedReferenceException;
import com.google.gson.JsonElement;

import java.util.HashMap;

public abstract class Parser<T> {

    /**
     * @param element The json element to parse
     * @param values  The values to resolve reference
     * @return The object
     * @throws UnresolvedReferenceException If the reference cannot be resolved yet
     */
    public T parse(JsonElement element, HashMap<String, Object> values) {
        if (element.isJsonPrimitive() && element.getAsString().startsWith("{") && element.getAsString().endsWith("}")) {
            String reference = element.getAsString();
            reference = reference.substring(1, reference.length() - 1);
            if (values.containsKey(reference)) return (T) values.get(reference);
            throw new UnresolvedReferenceException();
        }
        return parseValue(element, values);
    }

    protected abstract T parseValue(JsonElement element, HashMap<String, Object> values);
}
