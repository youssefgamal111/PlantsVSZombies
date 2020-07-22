package com.mygdx.game.Zombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.GifDecoder;

public class NormalZombie extends Zombie {
    public NormalZombie(float x, float y) {
        super(10, x, y, 10, 2);
    }

    protected Animation<TextureRegion> Standing, NormalAttacking, LostHeadAttacking, NormalWalking, LostHeadWalking;

    @Override
    protected void Load() {
        Standing = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\1.gif").read());
        NormalAttacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\ZombieAttack.gif").read());
        LostHeadAttacking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\ZombieLostHeadAttack.gif").read());
        NormalWalking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\Zombie.gif").read());
        LostHeadWalking = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("NormalZombie\\ZombieLostHead.gif").read());
        Dying = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("NormalZombie\\ZombieDie.gif").read());
        Default = Standing;
        Walking = NormalWalking;
        Attacking = NormalAttacking;
        SetCurrentAnimation(Default);
    }



    @Override
    protected void OnReceiveShot() {
        if (getHealth() == 5) {
            Walking = LostHeadWalking;
            SetCurrentAnimation(Walking);
            GameObjectFactory.AddGameObject(new NormalZombieHead(getX(), getY()));
            Attacking = LostHeadAttacking;
        }


    }
}
