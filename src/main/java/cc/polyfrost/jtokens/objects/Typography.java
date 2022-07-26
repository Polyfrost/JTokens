package cc.polyfrost.jtokens.objects;

public class Typography {
    private final String[] fontFamily;
    private final Dimension fontSize;
    private final int fontWeight;
    private final Dimension letterSpacing;
    private final float lineHeight;

    public Typography(String[] fontFamily, Dimension fontSize, int fontWeight, Dimension letterSpacing, float lineHeight) {
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
    public Dimension getFontSize() {
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
    public Dimension getLetterSpacing() {
        return letterSpacing;
    }

    /**
     * @return The line height in em
     */
    public float getLineHeight() {
        return lineHeight;
    }
}
