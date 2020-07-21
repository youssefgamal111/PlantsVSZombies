package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.GifDecoder;

public class NormalZombieHead extends GameObject {
    private static Animation<TextureRegion> Head
            = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("NormalZombie\\ZombieHead.gif").read());

    public NormalZombieHead(float x, float y) {
        super(0, x, y);
    }

    @Override
    protected void Load() {
        SetCurrentAnimation(Head);
        Remove();
    }

    @Override
    public void OnClick() {

    }

    @Override
    protected void OnRemove() {

    }

    @Override
    public void OnMoveStart() {

    }

    @Override
    public void OnMoveFinished() {

    }
}
