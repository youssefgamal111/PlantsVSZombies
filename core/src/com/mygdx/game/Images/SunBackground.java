package com.mygdx.game.Images;

import com.badlogic.gdx.graphics.Texture;

public class SunBackground extends Image {
    private static Texture img = new Texture("SunFactory/SunBack.png");

    public SunBackground() {
        super(110, 550);
        super.setImgTexture(img);
    }

    @Override
    public void OnClick() {

    }

    @Override
    protected void OnMoveStart() {

    }

    @Override
    protected void OnMoveFinished() {

    }
}
