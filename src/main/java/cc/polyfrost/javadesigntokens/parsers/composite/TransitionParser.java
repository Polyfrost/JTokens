package cc.polyfrost.javadesigntokens.parsers.composite;

import cc.polyfrost.javadesigntokens.objects.Transition;
import cc.polyfrost.javadesigntokens.parsers.Parser;
import cc.polyfrost.javadesigntokens.parsers.type.CubicBezierParser;
import cc.polyfrost.javadesigntokens.parsers.type.DurationParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class TransitionParser extends Parser<Transition> {
    public static final TransitionParser INSTANCE = new TransitionParser();

    @Override
    protected Transition parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonObject object = element.getAsJsonObject();
        float duration = DurationParser.INSTANCE.parse(object.get("duration"), values);
        float delay = DurationParser.INSTANCE.parse(object.get("delay"), values);
        float[] timingFunction = CubicBezierParser.INSTANCE.parse(object.get("timingFunction"), values);
        return new Transition(duration, delay, timingFunction);
    }
}
