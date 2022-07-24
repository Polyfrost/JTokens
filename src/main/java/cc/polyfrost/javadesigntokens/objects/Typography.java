package cc.polyfrost.javadesigntokens.objects;

public class Typography {
    private final String[] fontFamily;
    private final float fontSize;
    private final int fontWeight;
    private final float letterSpacing;
    private final float lineHeight;

    public Typography(String[] fontFamily, float fontSize, int fontWeight, float letterSpacing, float lineHeight) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.fontWeight = fontWeight;
        this.letterSpacing = letterSpacing;
        this.lineHeight = lineHeight;
    }

    /**
     * @return The font family
     */
    public String[] getFontFamily() {
        return fontFamily;
    }

    /**
     * @return The font size in pixels
     */
    public float getFontSize() {
        return fontSize;
    }

    /**
     * @return The font weight
     */
    public int getFontWeight() {
        return fontWeight;
    }

    /**
     * @return The letter spacing in pixels
     */
    public float getLetterSpacing() {
        return letterSpacing;
    }

    /**
     * @return The line height in pixels
     */
    public float getLineHeight() {
        return lineHeight;
    }
}
