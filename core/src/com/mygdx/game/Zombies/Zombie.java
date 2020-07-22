package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;
import com.mygdx.game.IAttackable;
import com.mygdx.game.IDamageable;
import com.mygdx.game.Timers.ZombieAttackTimer;

public abstract class Zombie extends GameObject implements IDamageable, IAttackable {
    protected Animation<TextureRegion> Walking, Attacking, Dying, Default;
    ZombieAttackTimer attacktimer;
    private int Health;
    private int Power;
    public static Sound eatSound;

    public Zombie(float moveSpeed, float x, float y, int Health, int Power) {
        super(moveSpeed, x, y);
        this.Health = Health;
        this.Power = Power;
        attacktimer = new ZombieAttackTimer(this);
        eatSound = Gdx.audio.newSound(Gdx.files.internal("NormalZombie\\zombie_eat_1.wav"));
    }

    @Override
    public int getHealth() {
        return Health;
    }

    @Override
    protected abstract void Load();


    @Override
    protected void OnRemove() {
        Stop();
        SetCurrentAnimation(Dying);
    }

    @Override
    public void OnMoveFinished() {
        SetCurrentAnimation(Default);
    }

    @Override
    public void OnMoveStart() {
        SetCurrentAnimation(Walking);

    }

    protected void OnReceiveShot() {

    }

    @Override
    public void ReceiveShot(IAttackable bullet) {
        if (this.isCanRemove())
            return;
        bullet.StartAttack(this);
        OnReceiveShot();
        Health -= bullet.getPower();
        if (Health <= 0)
            this.Remove();
    }

    @Override
    public void StartAttack(IDamageable object) {
        Stop();
        SetCurrentAnimation(Attacking);
        attacktimer.SetObject(object);
        attacktimer.Start();
    }

    @Override
    public void StopAttack() {
        attacktimer.Stop();
        Move(0, getY());

    }

    public int getPower() {
        return Power;
    }
}
