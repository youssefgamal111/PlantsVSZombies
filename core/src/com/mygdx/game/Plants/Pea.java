package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Zombies.Zombie;

public class Pea extends GameObject {
    public Pea(float x, float y) {
        super(100, x, y);
    }

    protected Animation<TextureRegion> Default, Hit;
    public boolean metZombie(GameObject z)
    {
       if(z.rect.contains(rect))
           return true;
       
       return false;
    }
    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PB00.gif").read());
        Hit = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaBulletHit.gif").read());
        SetCurrentAnimation(Default);
        Move(PlantVsZombies.WIDTH - 100, Y);
    }

    @Override
    public void OnRemove() {
        SetCurrentAnimation(Hit);
    }
   public void shoot(Zombie z)
{
      if(z.getHealth()==0 )
      {
         Remove();
          z.Kill();
          z.Remove();
      }
      else
          {
              Remove();
            z.setHealth( z.getHealth()-1) ;
          }
}
    @Override
    protected void OnMoveStart() {

    }

    @Override
    public void OnMoveFinished() {
        super.Remove();
//        PeaShooter
    }
}
