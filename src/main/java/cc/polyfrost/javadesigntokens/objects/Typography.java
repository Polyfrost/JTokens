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

    public String[] getFontFamily() {
        return fontFamily;
    }

    public float getFontSize() {
        return fontSize;
    }

    public int getFontWeight() {
        return fontWeight;
    }

    public float getLetterSpacing() {
        return letterSpacing;
    }

    public float getLineHeight() {
        return lineHeight;
    }
}
