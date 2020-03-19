package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.MyGdxGame;

public class PeaShooter extends Plant {
    public PeaShooter(float x, float y) {
        super(x, y);
    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        SetCurrentAnimation(Default);
    }

    public void Shot() {
        MyGdxGame.AddGameObject(new Pea(X + 35, Y + 37));
    }
}
