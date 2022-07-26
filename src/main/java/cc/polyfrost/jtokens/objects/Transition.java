package cc.polyfrost.jtokens.objects;

public class Transition {
    private final float duration;
    private final float delay;
    private final float[] timingFunction;

    public Transition(float duration, float delay, float[] timingFunction) {
        this.duration = duration;
        this.delay = delay;
        this.timingFunction = timingFunction;
    }

    /**
     * @return The duration in ms
     */
    public float getDuration() {
        return duration;
    }

    /**
     * @return The delay in ms
     */
    public float getDelay() {
        return delay;
    }

    /**
     * @return The bezier curve
     */
    public float[] getTimingFunction() {
        return timingFunction;
    }
}
