package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.FloatingSun;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.Timers.DropSunPlantTimer;
import com.mygdx.game.Timers.FloatingSunTimer;



public class SunFlower extends Plant {
    public Animation<TextureRegion> d2;
    private DropSunPlantTimer dropsunPlanttimer;
   private FloatingSunTimer floatingsuntimer;
   

    public SunFlower(float x, float y) {
        super(x, y,50);
        dropsunPlanttimer = new DropSunPlantTimer(this);
       dropsunPlanttimer.Start();
       

    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\SunFlower1.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\SunFlower1.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\SunFlower2.gif").read());
       d2=GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\SunFlower2.gif").read());
        SetCurrentAnimation(Default);
    }

   
    public void OnClick() {

    }
public void Drop(){
    SetCurrentAnimation(d2);
float x = (float) ((Math.random() *this.getWidth())+ this.getX() );
        float y = (float) ((Math.random() *this.getHeight())+ (this.getY()-50) );
     
        FloatingSun s = new FloatingSun(x, this.getY(),this);
        s.Move(x, y);
        GameObjectFactory.AddGameObject(s);
        SetCurrentAnimation(Default);



}
    @Override
    public void Remove() {
        super.Remove();
         dropsunPlanttimer.Remove();
         floatingsuntimer.Remove();
    }

    

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dropsunPlanttimer.Remove();
         floatingsuntimer.Remove();
    }
}
