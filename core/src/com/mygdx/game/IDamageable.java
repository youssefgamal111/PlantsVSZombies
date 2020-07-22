package com.mygdx.game;

public interface IDamageable {
    void ReceiveShot(IAttacker attacker);

    int getHealth();
}
