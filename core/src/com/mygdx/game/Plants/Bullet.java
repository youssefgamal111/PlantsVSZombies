package com.mygdx.game.Plants;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameObject;
import com.mygdx.game.IAttacker;
import com.mygdx.game.IDamageable;
import com.mygdx.game.IExplodeable;

public abstract class Bullet extends GameObject implements IAttacker, IExplodeable {
    Sound sound;
    private final int Power;

    public Bullet(float moveSpeed, float x, float y, int Power) {
        super(moveSpeed, x, y);
        this.Power = Power;
    }

    @Override
    public boolean CanAttack(GameObject obj) {
        return getX() > obj.getX() + 35;
    }

    @Override
    public void OnMoveStart() {

    }

    public void PlaySound() {
        if (sound != null)
            sound.play();
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    @Override
    public void OnMoveFinished() {
        super.Remove();
    }

    @Override
    public int getPower() {
        return Power;
    }

    @Override
    public void StartAttack(IDamageable obj) {

    }

    @Override
    public void StopAttack() {

    }

    @Override
    public void Explode() {
        Stop();
        PlaySound();
        Remove();
    }
}
