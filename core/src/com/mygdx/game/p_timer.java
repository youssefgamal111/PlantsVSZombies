package com.mygdx.game;

import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Zombies.Zombie;

public class p_timer extends Timer {
    public p_timer ()
    {
        super(2f);
    }
    public  void task()
    {
        for (GameObject obj : GameObjectFactory.getGameObjects()) {
            if (obj instanceof PeaShooter) {
                for (GameObject obj1 :GameObjectFactory.getGameObjects())
                {
                    if (obj1 instanceof Zombie)
                    {
                        if(obj.Row==obj1.Row)
                        {
                            ((PeaShooter) obj).Shot();
                        }
                    }
                }


            }
        }
    }
}
