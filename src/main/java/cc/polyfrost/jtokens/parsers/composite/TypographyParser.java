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
        Dimension letterSpacing;
        if (object.get("letterSpacing").getAsString().endsWith("em")) {// while em is not officially part of the spec, it is very useful
            if (fontSize.getUnit().equals(Dimension.Unit.PX)) {
                letterSpacing = new Dimension(Dimension.Unit.PX,
                        fontSize.getPx() * Float.parseFloat(StringParser.INSTANCE.parse(object.get("letterSpacing"), values).replace("em", "")));
            } else {
                letterSpacing = new Dimension(Dimension.Unit.REM,
                        fontSize.getRem() * Float.parseFloat(StringParser.INSTANCE.parse(object.get("letterSpacing"), values).replace("em", "")));
            }
        } else {
            letterSpacing = DimensionParser.INSTANCE.parse(object.get("letterSpacing"), values);
        }
        float lineHeight = Float.parseFloat(StringParser.INSTANCE.parse(object.get("lineHeight"), values));
        return new Typography(fontFamily, fontSize, fontWeight, letterSpacing, lineHeight);
    }
}
