package cc.polyfrost.jtokens.objects;

public class StrokeStyle {
    private final Style style;
    private final Dimension[] dashArray;
    private final LineCap lineCap;

    public StrokeStyle(Style style) {
        this.style = style;
        this.dashArray = null;
        this.lineCap = null;
    }

    public StrokeStyle(Dimension[] dashArray, LineCap lineCap) {
        this.style = Style.CUSTOM;
        this.dashArray = dashArray;
        this.lineCap = lineCap;
    }

    /**
     * @return The line style
     */
    public Style getStyle() {
        return style;
    }

    /**
     * @return Get the dash array,
     * this is null if the style isn't custom
     */
    public Dimension[] getDashArray() {
        return dashArray;
    }

    /**
     * @return Get the line cap,
     * this is null if the style isn't custom
     */
    public LineCap getLineCap() {
        return lineCap;
    }

    public enum Style {
        SOLID("solid"),
        DASHED("dashed"),
        DOTTED("dotted"),
        DOUBLE("double"),
        GROOVE("groove"),
        RIDGE("ridge"),
        OUTSET("outset"),
        INSET("inset"),
        CUSTOM("CUSTOM");

        public final String name;

        Style(String name) {
            this.name = name;
        }
    }

    public enum LineCap {
        ROUND("round"),
        BUTT("butt"),
        SQUARE("square");

        public final String name;

        LineCap(String name) {
            this.name = name;
        }
    }
}
