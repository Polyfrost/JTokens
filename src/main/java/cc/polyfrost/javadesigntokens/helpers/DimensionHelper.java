package cc.polyfrost.javadesigntokens.helpers;

import javafx.scene.text.Font;

public class DimensionHelper {
    private static final double pixelsPerRem = Font.getDefault().getSize() / 0.75;

    /**
     * Sloppy conversion from rem to pixels since we don't know the DPI
     *
     * @param rem The rem
     * @return The px
     */
    public static float remToPx(float rem) {
        return (float) (rem * pixelsPerRem);
    }

    /**
     * Sloppy conversion from pixels to rem since we don't know the DPI
     *
     * @param px The px
     * @return The rem
     */
    public static float pxToRem(float px) {
        return (float) (px / pixelsPerRem);
    }
}
