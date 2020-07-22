package com.mygdx.game.Plants;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.IAttackable;
import com.mygdx.game.IDamageable;

public abstract class Plant extends GameObject implements IDamageable {
    protected Animation<TextureRegion> Attacking, Dying, Default;
    private int Health;

    public Plant(float x, float y) {
        super(0, x, y);
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
    public void ReceiveShot(IAttackable z) {
        if (this.isCanRemove())
            return;
        Health -= z.getPower();
        if (Health <= 0) {
            this.Remove();
            z.StopAttack();
        }
    }
}
