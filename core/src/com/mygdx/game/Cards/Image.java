package com.mygdx.game.Cards;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public abstract class Image {
    public TextureRegion imgTexture;
    private float X, Y;
    public Rectangle rect;

    public abstract void OnClick();

    public boolean isCanRemove() {
        return CanRemove;
    }

    private boolean CanRemove;

    public Image() {
        CanRemove = false;
        rect = new Rectangle();
    }

    public Image(float x, float y) {
        this();
        X = x;
        Y = y;
        rect.setPosition(X, Y);
    }

    public TextureRegion getImgTexture() {
        return imgTexture;
    }

    public void setImgTexture(TextureRegion imgTexture) {
        this.imgTexture = imgTexture;
        rect.setHeight(imgTexture.getRegionHeight());
        rect.setWidth(imgTexture.getRegionWidth());
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
        rect.setX(x);
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
        rect.setY(y);
    }


}
