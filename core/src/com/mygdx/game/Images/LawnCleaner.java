package com.mygdx.game.Images;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.PlantVsZombies;

public class LawnCleaner extends Image {
    private static Texture LawnTexture = new Texture("LawnCleaner.png");

    public LawnCleaner(float x, float y) {
        super(1000, x, y);
        setImgTexture(LawnTexture);
    }

    @Override
    public void OnClick() {
        Move(PlantVsZombies.WIDTH - 100, getY());
    }

    @Override
    protected void OnMoveStart() {

    }

    @Override
    protected void OnMoveFinished() {
        super.Remove();
    }
}
