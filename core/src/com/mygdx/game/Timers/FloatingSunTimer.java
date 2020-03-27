package com.mygdx.game.Timers;

import com.mygdx.game.FloatingSun;

public class FloatingSunTimer extends Timer {
    private final FloatingSun sun;

    public FloatingSunTimer(FloatingSun sun) {
        super(10);
        this.sun = sun;
    }

    @Override
    public void task() {
        sun.Remove();
    }
}
