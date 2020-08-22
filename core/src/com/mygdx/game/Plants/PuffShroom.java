package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.Timers.PuffShroomTimer;

public class PuffShroom extends Plant {
    private PuffShroomTimer timer;
    private static Sound pSound;

    public PuffShroom(float x, float y) {
        super(x, y, 10);
        timer = new PuffShroomTimer(this);
        timer.Start();
        pSound = Gdx.audio.newSound(Gdx.files.internal("Peashooter\\pea_shoot_1.wav"));

    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Puffshroom.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaShooter\\Puffshroom.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PeaShooter\\Puffshroom.gif").read());
        SetCurrentAnimation(Default);
    }

    @Override
    public void Remove() {
        super.Remove();
        timer.Remove();
    }

    public void Shot() {
        Puff pp = new Puff(getX() + 35, getY() + 37);
        pp.Row = Row;
        GameObjectFactory.AddGameObject(pp);
        pSound.play();
    }
}

