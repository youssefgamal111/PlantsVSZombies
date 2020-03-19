package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.GifDecoder;

public class Pea extends GameObject {
    public Pea(float x, float y) {
        super(50, x, y);
    }

    protected Animation<TextureRegion> Default, Hit;

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PB00.gif").read());
        Hit = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaBulletHit.gif").read());
        SetCurrentAnimation(Default);
        Move(400, Y);
    }

    @Override
    protected void OnRemove() {
        SetCurrentAnimation(Hit);
    }

    @Override
    protected void OnMoveStart() {

    }

    @Override
    protected void OnMoveFinished() {
        super.Remove();
    }
}
