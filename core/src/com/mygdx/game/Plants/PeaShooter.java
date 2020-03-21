package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.MainGameScreen;

public class PeaShooter extends Plant {
    public boolean shoot;
    public Pea pea;
    public PeaShooter(float x, float y) {
        super(x, y);
        shoot=false;
        
    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        SetCurrentAnimation(Default);
    }

    public Pea Shot() {
//        MainGameScreen.AddGameObject(new Pea(X + 35, Y + 37));
        Pea pp=new Pea(X + 35, Y + 37);
        MainGameScreen.AddGameObject(pp);
        return pp;
    }
}
