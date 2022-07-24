package cc.polyfrost.javadesigntokens;

import cc.polyfrost.javadesigntokens.parsers.type.DimensionParser;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ParsingTest {

    @Test
    public void basicValuesTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getString("string").equals("abc");
            assert designToken.getFloat("number") == 1.5f;
            assert designToken.getBoolean("boolean");
            assert designToken.getObject("object").get("abc").getAsBoolean();
            assert designToken.getArray("array").get(0).getAsString().equals("abc");
        }
    }

    @Test
    public void testColor() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.has("colors.white");
            assert !designToken.has("colors.not-white");
            assert designToken.getColor("colors.white").equals(new Color(255, 255, 255));
        }
    }

    @Test
    public void testReference() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.get("colors.white").equals(designToken.get("button.button-color"));
            assert designToken.get("button.button-color").equals(designToken.get("button.other-color"));
        }
    }

    @Test
    public void testFontFamily() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert Arrays.equals(designToken.getFontFamily("Primary font"), new String[]{"Comic Sans MS"});
            assert Arrays.equals(designToken.getFontFamily("Body font"), new String[]{"Helvetica", "Arial"});
        }
    }

    @Test
    public void testFontWeight() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getFontWeight("font-weight-default") == 350;
            assert designToken.getFontWeight("font-weight-thick") == 800;
        }
    }

    @Test
    public void testDimension() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert DimensionParser.INSTANCE.remToPx(0.25f) == 4;
            assert designToken.getDimension("rem") == DimensionParser.INSTANCE.remToPx(0.25f);
            assert designToken.getDimension("px") == 10;
        }
    }

    @Test
    public void durationTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getDuration("Duration-100") == 100;
            assert designToken.getDuration("Duration-200") == 200;
        }
    }

    @Test
    public void cubicBezierTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert Arrays.equals(designToken.getCubicBezier("Accelerate"), new float[]{0.5f, 0, 1, 1});
            assert Arrays.equals(designToken.getCubicBezier("Decelerate"), new float[]{0, 0, 0.5f, 1});
        }
    }

    @Test
    public void multipleFilesTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design3.tokens.json"), StandardCharsets.UTF_8));
             BufferedReader reader2 = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design2.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader, reader2);
            assert designToken.getColor("colors.white").equals(designToken.getColor("file1-file2"));
            assert designToken.getColor("random-color").equals(designToken.getColor("file2-file1"));
            assert designToken.getDuration("priority") == 1;
        }
    }

    @Test
    public void typographyTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getTypography("font.main").getFontFamily()[0].equals("Roboto");
            assert designToken.getTypography("font.main").getFontSize() == 42;
            assert designToken.getTypography("font.main").getFontWeight() == 700;
            assert designToken.getTypography("font.main").getLetterSpacing() == 42;
            assert designToken.getTypography("font.main").getLineHeight() == 84;
            assert designToken.getTypography("font.main").equals(designToken.getTypography("font.main-clone"));
            assert designToken.getTypography("font.secondary").getFontFamily()[0].equals(designToken.getFontFamily("Primary font")[0]);
            assert designToken.getTypography("font.secondary").getFontWeight() == designToken.getFontWeight("font-weight-thick");
            assert designToken.getTypography("font.secondary").getLetterSpacing() == designToken.getDimension("px");
        }
    }

    @Test
    public void shadowTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getShadow("shadow").getColor().equals(new Color(0, 0, 0));
            assert designToken.getShadow("shadow").getOffsetX() == 8;
            assert designToken.getShadow("shadow").getOffsetY() == 8;
            assert designToken.getShadow("shadow").getBlur() == 24;
            assert designToken.getShadow("shadow").getSpread() == 0;
        }
    }

    @Test
    public void transitionTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.getTransition("transition").getDuration() == 200;
            assert designToken.getTransition("transition").getDelay() == 0;
            assert Arrays.equals(designToken.getTransition("transition").getTimingFunction(), new float[]{0.5f, 0, 1, 1});
        }
    }
}
