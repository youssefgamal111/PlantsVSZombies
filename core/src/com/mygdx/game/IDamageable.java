package com.mygdx.game;

public interface IDamageable {
    void ReceiveShot(IAttackable attacker);

    int getHealth();
}
