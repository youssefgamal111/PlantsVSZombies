package com.mygdx.game.Plants;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.IAttacker;
import com.mygdx.game.IDamageable;

public abstract class Plant extends GameObject implements IDamageable {
    public Animation<TextureRegion> Attacking, Dying, Default;
    int Health;

    public Plant(float x, float y, int Health) {
        super(0, x, y);
        this.Health = Health;
    }

    @Override
    protected abstract void Load();

    @Override
    protected void OnRemove() {
        SetCurrentAnimation(Dying);
    }

    @Override
    public void OnMoveStart() {
        //nothing
    }

    @Override
    public void OnMoveFinished() {
        //nothing
    }

    public int getHealth() {
        return Health;
    }

    @Override
    public void ReceiveShot(IAttacker z) {
        if (this.isCanRemove())
            return;
        Health -= z.getPower();
        if (Health <= 0) {
            this.Remove();
            z.StopAttack();
        }
    }
}
