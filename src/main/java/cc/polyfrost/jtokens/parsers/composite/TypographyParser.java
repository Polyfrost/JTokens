package cc.polyfrost.jtokens.parsers.composite;

import cc.polyfrost.jtokens.objects.Dimension;
import cc.polyfrost.jtokens.parsers.Parser;
import cc.polyfrost.jtokens.parsers.json.StringParser;
import cc.polyfrost.jtokens.parsers.type.DimensionParser;
import cc.polyfrost.jtokens.parsers.type.FontFamilyParser;
import cc.polyfrost.jtokens.parsers.type.FontWeightParser;
import cc.polyfrost.jtokens.objects.Typography;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class TypographyParser extends Parser<Typography> {
    public static TypographyParser INSTANCE = new TypographyParser();

    @Override
    protected Typography parseValue(JsonElement element, HashMap<String, Object> values) {
        JsonObject object = element.getAsJsonObject();
        String[] fontFamily = FontFamilyParser.INSTANCE.parse(object.get("fontFamily"), values);
        Dimension fontSize = DimensionParser.INSTANCE.parse(object.get("fontSize"), values);
        int fontWeight = FontWeightParser.INSTANCE.parse(object.get("fontWeight"), values);
        Dimension letterSpacing = DimensionParser.INSTANCE.parse(object.get("letterSpacing"), values);
        float lineHeight = Float.parseFloat(StringParser.INSTANCE.parse(object.get("lineHeight"), values));
        return new Typography(fontFamily, fontSize, fontWeight, letterSpacing, lineHeight);
    }
}
