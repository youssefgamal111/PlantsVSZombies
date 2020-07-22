package com.mygdx.game;

public interface IAttacker {
    void StartAttack(IDamageable obj);

    int getPower();

    void StopAttack();

    boolean CanAttack(GameObject obj);
}
