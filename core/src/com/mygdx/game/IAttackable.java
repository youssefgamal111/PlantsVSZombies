package com.mygdx.game;

public interface IAttackable {
    void StartAttack(IDamageable obj);

    int getPower();

    void StopAttack();
}
