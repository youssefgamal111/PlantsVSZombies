package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.*;
import com.mygdx.game.Timers.ZombieAttackTimer;

public abstract class Zombie extends GameObject implements IDamageable, IAttacker {
    protected Animation<TextureRegion> Walking, Attacking, Dying, Default;
    ZombieAttackTimer AttackTimer;
    private int Health;
    private int Power;
    public static Sound eatSound;

    public Zombie(float moveSpeed, float x, float y, int Health, int Power) {
        super(moveSpeed, x, y);
        this.Health = Health;
        this.Power = Power;
        AttackTimer = new ZombieAttackTimer(this);
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
        AttackTimer.Remove();
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
    public void ReceiveShot(IAttacker attacker) {
        if (this.isCanRemove())
            return;
        attacker.StartAttack(this);
        if (attacker instanceof IExplodeable)
            ((IExplodeable) attacker).Explode();
        OnReceiveShot();
        Health -= attacker.getPower();
        if (Health <= 0)
            this.Remove();
    }

    @Override
    public void StartAttack(IDamageable object) {
        if (state == State.Attacking || isCanRemove())
            return;
        Stop();
        SetCurrentAnimation(Attacking);
        this.state = State.Attacking;
        AttackTimer.SetObject(object);
        AttackTimer.Start();
    }

    @Override
    public void StopAttack() {
        AttackTimer.Stop();
        Move(0, getY());

    }

    @Override
    public int getPower() {
        return Power;
    }

    @Override
    public boolean CanAttack(GameObject obj) {
        return getX() < obj.getX();
    }

}
