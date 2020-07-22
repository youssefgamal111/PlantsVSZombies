package com.mygdx.game.Timers;

import com.mygdx.game.IDamageable;
import com.mygdx.game.Zombies.Zombie;

public class ZombieAttackTimer extends Timer {
    Zombie zombie;
    IDamageable plant;

    public ZombieAttackTimer(Zombie zombie) {
        super(1f);
        this.zombie = zombie;
    }

    public void SetObject(IDamageable obj) {
        this.plant = plant;
    }

    @Override
    public void task() {
        plant.ReceiveShot(zombie);
    }
}
