package com.mygdx.game.Plants;

import com.mygdx.game.GameObject;

public abstract class Bullet extends GameObject {

    private final int Power;

    public Bullet(float moveSpeed, float x, float y, int Power) {
        super(moveSpeed, x, y);
        this.Power = Power;
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
