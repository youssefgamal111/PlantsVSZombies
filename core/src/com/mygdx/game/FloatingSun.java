package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.SunFactory;
import com.mygdx.game.Timers.FloatingSunTimer;

public class FloatingSun extends GameObject {
    private Animation<TextureRegion> FloatingSun;
    private final FloatingSunTimer timer;

    public FloatingSun(float x, float y) {
        super(30, x, y);
        timer = new FloatingSunTimer(this);
    }

    @Override
    protected void Load() {
        FloatingSun = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("SunFactory/Sun.gif").read());
        FloatingSun.setFrameDuration(0.02f);
        SetCurrentAnimation(FloatingSun);
    }

    @Override
    public void OnClick() {
        this.Remove();
        SunFactory.CollectedSuns += 100;
    }

    @Override
    protected void OnRemove() {
    }

    @Override
    protected void OnMoveStart() {
    }

    @Override
    protected void OnMoveFinished() {
        timer.Start();
    }

}