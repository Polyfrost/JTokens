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
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/polyui.tokens.json"), StandardCharsets.UTF_8))) {
            DesignToken designToken = new DesignToken(reader);
            assert designToken.has("polyui.core.color.blue.500");
            assert !designToken.has("polyui.core.color.blue.501");
            assert designToken.isColor("polyui.core.color.blue.500");
            assert !designToken.isColor("polyui.core.color.blue.501");
            assert designToken.getColor("polyui.core.color.blue.500").equals(new Color(	31, 101, 214));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
