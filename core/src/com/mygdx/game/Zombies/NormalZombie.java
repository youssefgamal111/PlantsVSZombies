package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.GifDecoder;

public class NormalZombie extends Zombie {
    public NormalZombie(float x, float y) {
        super(100,40, x, y);
    }

    @Override
    protected void Load() {
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\1.gif").read());
        Walking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\Zombie.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("NormalZombie\\ZombieDie.gif").read());
        Attacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\ZombieAttack.gif").read());
        SetCurrentAnimation(Default);
    }
}
