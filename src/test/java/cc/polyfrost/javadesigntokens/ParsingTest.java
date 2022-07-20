package cc.polyfrost.javadesigntokens;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ParsingTest {

    @Test
    public void testColor() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.has("colors.white");
            assert !designToken.has("colors.not-white");
            assert designToken.isColor("colors.white");
            assert !designToken.isColor("colors.not-white");
            assert designToken.getColor("colors.white").equals(new Color(255, 255, 255));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReference() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/design.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.get("colors.white").equals(designToken.get("button.button-color"));
            assert designToken.get("button.button-color").equals(designToken.get("button.other-color"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
