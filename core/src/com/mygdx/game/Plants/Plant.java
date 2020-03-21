package com.mygdx.game.Plants;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Plant extends GameObject {
    protected Animation<TextureRegion> Attacking, Dying, Default;

    public Plant(float x, float y) {
        super(100,0, x, y);
    }

    @Override
    protected abstract void Load();

    @Override
    protected void OnRemove() {
        SetCurrentAnimation(Dying);
    }

    @Override
    protected void OnMoveStart() {
        //nothing
    }

    @Override
    protected void OnMoveFinished() {
        //nothing
    }
}
