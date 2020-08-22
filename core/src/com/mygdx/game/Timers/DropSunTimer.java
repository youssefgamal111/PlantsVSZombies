package com.mygdx.game.Timers;

import com.mygdx.game.Factories.SunFactory;
import com.mygdx.game.Plants.SunFlower;

public class DropSunTimer extends Timer {
    public DropSunTimer() {
        super(6f);
    }

    @Override
    public void task() {
        SunFactory.DropSun();
    }
}
