package com.mygdx.game.Plants;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Bullet extends GameObject {

    protected Animation<TextureRegion> Default, Hit;
    private final int Power;

    public Bullet(float moveSpeed, float x, float y, int Power) {
        super(moveSpeed, x, y);
        this.Power = Power;
    }

    @Override
    public void OnRemove() {
        SetCurrentAnimation(Hit);
    }


    @Override
    protected void OnMoveStart() {

    }

    @Override
    public void OnMoveFinished() {
        super.Remove();
    }

    public int getPower() {
        return Power;
    }
}
