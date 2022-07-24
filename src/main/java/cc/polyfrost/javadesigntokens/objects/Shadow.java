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

    /**
     * @return The color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return The X offset in pixels
     */
    public float getOffsetX() {
        return offsetX;
    }

    /**
     * @return The Y offset in pixels
     */
    public float getOffsetY() {
        return offsetY;
    }

    /**
     * @return The blur radius in pixels
     */
    public float getBlur() {
        return blur;
    }

    /**
     * @return The spread in pixels
     */
    public float getSpread() {
        return spread;
    }
}
