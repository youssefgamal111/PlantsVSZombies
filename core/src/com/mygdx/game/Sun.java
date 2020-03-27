package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class Sun extends GameObject {
    private Animation<TextureRegion> FloatingSun;

    public Sun(float x, float y) {
        super(30, x, y);
    }

    @Override
    protected void Load() {
        FloatingSun = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("SunFactory/Sun.gif").read());
        FloatingSun.setFrameDuration(0.05f);
        SetCurrentAnimation(FloatingSun);
    }

    @Override
    protected void OnRemove() {

    }

    @Override
    protected void OnMoveStart() {
    }

    @Override
    protected void OnMoveFinished() {

    }

}