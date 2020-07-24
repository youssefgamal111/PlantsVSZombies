package com.mygdx.game.Timers;

import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GameObject;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Zombies.Zombie;

public class PeashooterTimer extends Timer {
    private final PeaShooter peaShooter;

    public PeashooterTimer(PeaShooter peaShooter) {
        super(2f);
        this.peaShooter = peaShooter;
    }

    @Override
    public void task() {
        for (GameObject obj : GameObjectFactory.GetObjectsInRow(peaShooter.Row)) {
            if (obj instanceof Zombie) {
                if (obj.getX() > peaShooter.getX()-50)
                    peaShooter.Shot();
                return;
            }

        }
    }
}
