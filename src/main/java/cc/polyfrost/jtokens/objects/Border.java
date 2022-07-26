package cc.polyfrost.jtokens.objects;

import java.awt.*;

public class Border {
    private final Color color;
    private final Dimension width;
    private final StrokeStyle strokeStyle;

    public Border(Color color, Dimension width, StrokeStyle strokeStyle) {
        this.color = color;
        this.width = width;
        this.strokeStyle = strokeStyle;
    }

    /**
     * @return The color of the border
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return The width of the border
     */
    public Dimension getWidth() {
        return width;
    }

    /**
     * @return The stroke style of the border
     */
    public StrokeStyle getStrokeStyle() {
        return strokeStyle;
    }
}
