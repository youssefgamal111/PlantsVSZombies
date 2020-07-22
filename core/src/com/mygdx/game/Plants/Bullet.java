package com.mygdx.game.Plants;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GameObject;
import com.mygdx.game.IAttackable;
import com.mygdx.game.IDamageable;

public abstract class Bullet extends GameObject implements IAttackable {
    private Sound sound;
    private final int Power;

    public Bullet(float moveSpeed, float x, float y, int Power) {
        super(moveSpeed, x, y);
        this.Power = Power;
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
        Stop();
        PlaySound();
        Remove();
    }

    @Override
    public void StopAttack() {

    }
}
