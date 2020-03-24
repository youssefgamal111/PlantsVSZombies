package com.mygdx.game.Zombies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Zombie extends GameObject {
    protected Animation<TextureRegion> Walking, Attacking, Dying, Default;
    private int Health;
    private int Row;

    public Zombie(float moveSpeed, float x, float y, int Health) {
        super(moveSpeed, x, y);
        this.Health = Health;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    @Override
    protected abstract void Load();

    public void Kill() {
        super.Remove();
    }

    @Override
    protected void OnRemove() {
        SetCurrentAnimation(Dying);
    }

    @Override
    protected void OnMoveFinished() {
        SetCurrentAnimation(Default);

    }

    @Override
    protected void OnMoveStart() {
        SetCurrentAnimation(Walking);

    }

}
