package com.mygdx.game.Images;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Image {
    public TextureRegion imgTexture;
    public Rectangle rect;
    private float X, Y;
    private float TargetX, TargetY;
    private float MoveSpeed;
    private boolean CanRemove;

    public Image() {
        CanRemove = false;
        rect = new Rectangle();
        this.MoveSpeed = 0;
    }

    public Image(float x, float y) {
        this();
        X = TargetX = x;
        Y = TargetY = y;
        rect.setPosition(X, Y);
    }

    public Image(float MoveSpeed, float x, float y) {
        this(x, y);
        this.MoveSpeed = MoveSpeed;
    }

    public abstract void OnClick();

    protected abstract void OnMoveStart();

    protected abstract void OnMoveFinished();

    public void Move(float x, float y) {
        if (MoveSpeed == 0)
            return;
        if (X == x && Y == y)
            return;
        TargetX = x;
        TargetY = y;
        OnMoveStart();
    }

    public void Render() {
        float deltatime = Gdx.graphics.getDeltaTime();
        if (X == TargetX && Y == TargetY)
            return;
        if (X > TargetX)
            X = Math.max(X - MoveSpeed * deltatime, TargetX);
        else if (X < TargetX)
            X = Math.min(X + MoveSpeed * deltatime, TargetX);
        if (Y > TargetY)
            Y = Math.max(Y - MoveSpeed * deltatime, TargetY);
        else if (Y < TargetY)
            Y = Math.min(Y + MoveSpeed * deltatime, TargetY);
        if (X == TargetX && Y == TargetY) {
            OnMoveFinished();
        }
    }

    public TextureRegion getImgTexture() {
        return imgTexture;
    }

    public void setImgTexture(TextureRegion imgTexture) {
        this.imgTexture = imgTexture;
        rect.setHeight(imgTexture.getRegionHeight());
        rect.setWidth(imgTexture.getRegionWidth());
    }

    public void setImgTexture(Texture imgTexture) {
        this.imgTexture = new TextureRegion(imgTexture);
        rect.setHeight(imgTexture.getHeight());
        rect.setWidth(imgTexture.getWidth());
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

    public boolean isCanRemove() {
        return CanRemove;
    }

    public void Remove() {
        this.CanRemove = true;
    }

}
