package cc.polyfrost.jtokens.objects;

import java.awt.*;

public class Shadow {
    private final Color color;
    private final Dimension offsetX;
    private final Dimension offsetY;
    private final Dimension blur;
    private final Dimension spread;

    public Shadow(Color color, Dimension offsetX, Dimension offsetY, Dimension blur, Dimension spread) {
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
     * @return The X offset
     */
    public Dimension getOffsetX() {
        return offsetX;
    }

    /**
     * @return The Y offset
     */
    public Dimension getOffsetY() {
        return offsetY;
    }

    /**
     * @return The blur radius
     */
    public Dimension getBlur() {
        return blur;
    }

    /**
     * @return The spread
     */
    public Dimension getSpread() {
        return spread;
    }
}
