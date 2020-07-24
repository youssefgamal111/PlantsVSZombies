package com.mygdx.game.Timers;

import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GameObject;
import com.mygdx.game.Plants.Repeater;
import com.mygdx.game.Zombies.Zombie;

public class RepeaterTimer extends Timer {
      private final Repeater repeater;

    public RepeaterTimer(Repeater repeater) {
        super(3f);
        this.repeater=repeater;
    }

    

   
    @Override
    public void task() {
        for (GameObject obj : GameObjectFactory.GetObjectsInRow(repeater.Row)) {
            if (obj instanceof Zombie) {
                if (obj.getX() > repeater.getX()-50)
                repeater.Shot();
                return;
            }

        }
    }
}
