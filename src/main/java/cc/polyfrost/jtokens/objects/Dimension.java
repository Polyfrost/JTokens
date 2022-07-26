package cc.polyfrost.jtokens.objects;

public class Dimension {
    private final Unit unit;
    private final float value;

    public Dimension(Unit unit, float value) {
        this.unit = unit;
        this.value = value;
    }

    /**
     * @return The unit of the dimension, either PX or REM
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * @return Get the dimension in pixels, if the unit is rem automatic conversion is done
     */
    public float getPx() {
        if (unit.equals(Unit.PX)) return value;
        return value * 16;
    }

    /**
     * @return Get the dimension in rem, if the unit is pixels automatic conversion is done
     */
    public float getRem() {
        if (unit.equals(Unit.REM)) return value;
        return value / 16;
    }

    public enum Unit {
        PX,
        REM
    }
}
