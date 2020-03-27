package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.Timers.PeashooterTimer;


public class PeaShooter extends Plant {
    private PeashooterTimer timer;

    public PeaShooter(float x, float y) {
        super(x, y);
        timer = new PeashooterTimer(this);
        timer.Start();
    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Peashooter.gif").read());
        SetCurrentAnimation(Default);
    }

    @Override
    public void OnClick() {

    }

    @Override
    public void Remove() {
        super.Remove();
        timer.Remove();
    }

    public void Shot() {
        Pea pp = new Pea(getX() + 35, getY() + 37);
        pp.Row = Row;
        GameObjectFactory.AddGameObject(pp);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        timer.Remove();
    }
}
