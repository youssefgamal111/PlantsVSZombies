package com.mygdx.game.Plants;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameObject;

public abstract class Bullet extends GameObject {
    public Sound sound;
    private final int Power;

    public Bullet(float moveSpeed, float x, float y, int Power) {
        super(moveSpeed, x, y);
        this.Power = Power;
    }

    @Override
    protected void OnMoveStart() {

    }

    public void PlaySound() {
        if (sound != null)
            sound.play();
    }

    @Override
    public void OnMoveFinished() {
        super.Remove();
    }

    public int getPower() {
        return Power;
    }
}
