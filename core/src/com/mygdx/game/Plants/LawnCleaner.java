package com.mygdx.game.Plants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GifDecoder;
import com.mygdx.game.PlantVsZombies;

public class LawnCleaner extends Bullet {
    private static Animation<TextureRegion> FloatingSun =
            GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("lawncleaner.gif").read());

    public LawnCleaner(float x, float y, int row) {
        super(1000, x, y, 1000);
        Row = row;
    }

    @Override
    protected void Load() {
        SetCurrentAnimation(FloatingSun);
    }

    @Override
    public void OnClick() {

    }

    @Override
    protected void OnRemove() {
        Move(PlantVsZombies.WIDTH - 100, getY());
    }

    @Override
    protected void OnMoveStart() {

    }

    @Override
    public void OnMoveFinished() {
        super.Remove();
    }
}
