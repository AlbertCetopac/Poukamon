package com.iut.poukamon.model;

/**
 * @author Chlorodatafile
 */
public class TickTimer {

    private final int max;
    private float ticks;

    public TickTimer(int init, int max) {
        this.max = max == 0
                ? 1
                : max < 0
                ? -max
                : max;
        ticks = init > this.max
                ? this.max
                : init < -this.max
                ? -this.max
                : init;
    }

    public TickTimer(int init) {
        this(init, init);
    }

    public TickTimer() {
        this(0, 1);
    }

    public void update() {
        if (ticks > 0)
            ticks--;
        else if (ticks != 0)
            ticks++;
    }

    public void reset() {
        ticks = max;
    }

    public void reset(boolean plus) {
        ticks = plus ? max : -max;
    }

    public int getMax() {
        return max;
    }

    public int getTicks() {
        return (int) ticks;
    }

    public float toFloat() {
        return ticks / max;
    }

    public boolean isCounting() {
        return ticks != 0;
    }

    public boolean isFinished() {
        return ticks == 0;
    }

}
