package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.Plants.Bullet;

public abstract class Zombie extends GameObject {
    protected Animation<TextureRegion> Walking, Attacking, Dying, Default;
    private int Health;
    public static Sound eatSound;
    public Zombie(float moveSpeed, float x, float y, int Health) {
        super(moveSpeed, x, y);
        this.Health = Health;
        eatSound=Gdx.audio.newSound(Gdx.files.internal("NormalZombie\\zombie_eat_1.wav")); 
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
        Stop();
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

    protected void OnReceiveShot() {

    }

    public void ReceiveShot(Bullet bullet) {
        if (this.isCanRemove())
            return;
        bullet.Stop();
        bullet.PlaySound();
        bullet.Remove();
        OnReceiveShot();
        Health -= bullet.getPower();
        if (Health <= 0)
            this.Remove();
    }


}
