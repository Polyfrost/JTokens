package cc.polyfrost.javadesigntokens.objects;

import java.awt.*;

public class Shadow {
    private final Color color;
    private final float offsetX;
    private final float offsetY;
    private final float blur;
    private final float spread;

    public Shadow(Color color, float offsetX, float offsetY, float blur, float spread) {
        this.color = color;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.blur = blur;
        this.spread = spread;
    }

    public Color getColor() {
        return color;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public float getBlur() {
        return blur;
    }

    public float getSpread() {
        return spread;
    }
}
