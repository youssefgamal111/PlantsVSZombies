package com.mygdx.game.Timers;

import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.Zombies.NormalZombie;

import java.util.Random;

public class ZombieGeneratorTimer extends Timer {
    public ZombieGeneratorTimer(float time) {
        super(time);
    }

    @Override
    public void task() {
        GameObjectFactory.AddZombie(new NormalZombie(0, 0), new Random().nextInt(4));

    }
}
