package com.mygdx.game.Plants;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.PlantVsZombies;


public class Pea extends Bullet {
    private Animation<TextureRegion> Default, Hit;

    public Pea(float x, float y) {

        super(100, x, y, 1);

    }


    @Override

    protected void Load() {
        sound = Gdx.audio.newSound(Gdx.files.internal("pea_hit_1.wav"));    
        Default = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("PB00.gif").read());

        Hit = GifDecoder.loadGIFAnimation(Animation.PlayMode.NORMAL, Gdx.files.internal("PeaBulletHit.gif").read());

        SetCurrentAnimation(Default);

        Move(PlantVsZombies.WIDTH - 100, getY());

    }

    @Override
    public void OnClick() {

    }

    @Override
    protected void OnRemove() {
    SetCurrentAnimation(Hit);
    }


}