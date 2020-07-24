package com.mygdx.game.Timers;

import com.mygdx.game.IDamageable;
import com.mygdx.game.Zombies.Zombie;

public class ZombieAttackTimer extends Timer {
    Zombie zombie;
    IDamageable obj;

    public ZombieAttackTimer(Zombie zombie) {
        super(1f);
        this.zombie = zombie;
    }

    public void SetObject(IDamageable obj) {
        this.obj = obj;
    }

    @Override
    public void task() {
        obj.ReceiveShot(zombie);
        if (obj.getHealth() <= 0)
            zombie.StopAttack();
    }
}
