package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.SunFactory;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Timers.FloatingSunTimer;

public class FloatingSun extends GameObject implements IClickable {
    private Animation<TextureRegion> FloatingSun;
    private final FloatingSunTimer timer;
    private Plant Owner;

    public FloatingSun(float x, float y) {
        super(30, x, y);
        timer = new FloatingSunTimer(this);
    }

    public FloatingSun(float x, float y, Plant Owner) {
        this(x, y);
        this.Owner = Owner;
    }

    @Override
    protected void Load() {
        FloatingSun = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("SunFactory/Sun.gif").read());
        FloatingSun.setFrameDuration(0.02f);
        SetCurrentAnimation(FloatingSun);
    }

    @Override
    public void OnClick() {
        this.Stop();
        this.Remove();
        SunFactory.setCollectedSuns(SunFactory.getCollectedSuns() + 50);
    }

    @Override
    protected void OnRemove() {
        timer.Remove();
        if (Owner != null)
            Owner.SetCurrentAnimation(Owner.Default);
    }

    @Override
    public void OnMoveStart() {
    }

    @Override
    public void OnMoveFinished() {
        timer.Start();
    }

}
