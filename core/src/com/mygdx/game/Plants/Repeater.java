package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.Timers.RepeaterTimer;

public class Repeater extends Plant {
    private RepeaterTimer timer;
    private static Sound pSound;

    public Repeater(float x, float y) {
        super(x, y, 50);
        timer = new RepeaterTimer(this);
        timer.Start();
        pSound = Gdx.audio.newSound(Gdx.files.internal("Peashooter\\pea_shoot_1.wav"));

    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Repeater.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\Repeater.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Repeater.gif").read());
        SetCurrentAnimation(Default);
    }


    public void Shot() {
        Pea p1 = new Pea(getX() + 15, getY() + 37);
        p1.Row = Row;
        Pea p2 = new Pea(getX() + 40, getY() + 37);
        p2.Row = Row;
        GameObjectFactory.AddGameObject(p1);
        GameObjectFactory.AddGameObject(p2);
        pSound.play();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        timer.Remove();
    }

}
