package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.GifDecoder;

public class NormalZombie extends Zombie {
    public NormalZombie(float x, float y) {
        super(50, x, y);
    }

    @Override
    public void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Zombie\\1.gif").read());
        Walking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Zombie\\Zombie.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("Zombie\\ZombieDie.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Zombie\\ZombieAttack.gif").read());
        SetCurrentAnimation(Default);
    }
}
