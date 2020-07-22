package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class GameObject implements IMoveable {
	private final float MoveSpeed;
	protected State state;
	private float X;
	private float Y;
	public int Row;
	private boolean CanRemove;
	private float TargetX, TargetY, animationElapsedTime;
	private Animation<TextureRegion> currentAnimation;

	public GameObject(float moveSpeed, float x, float y) {
		MoveSpeed = moveSpeed;
		X = TargetX = x;
		Y = TargetY = y;
		CanRemove = false;
		Load();
	}

	protected abstract void Load();

	protected abstract void OnRemove();


    public void SetCurrentAnimation(Animation<TextureRegion> animation) {
        currentAnimation = animation;
        animationElapsedTime = 0f;
	}

	public TextureRegion GetCurrentFrame() {
		return currentAnimation.getKeyFrame(animationElapsedTime);
	}

	public int getHeight() {
		return GetCurrentFrame().getRegionHeight();
	}

	public int getWidth() {
		return GetCurrentFrame().getRegionWidth();
	}

	public void Remove() {
		if (this.CanRemove)
			return;
		this.CanRemove = true;
		OnRemove();
	}

	@Override
	public boolean IsMoving() {
		return this.state == State.Moving;
	}

	public boolean CanRemove() {
		return currentAnimation.isAnimationFinished(animationElapsedTime) && CanRemove && !IsMoving();
	}

	@Override
	public void Move(float x, float y) {
		if (MoveSpeed == 0)
			return;
		if (X == x && Y == y)
			return;
		TargetX = x;
		TargetY = y;
		OnMoveStart();
		this.state = State.Moving;
	}

    public void Render() {
        float deltatime = Gdx.graphics.getDeltaTime();
        animationElapsedTime += deltatime;
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
			this.state = State.Static;
        }
	}

	public void Stop() {
		TargetX = X;
		TargetY = Y;
		this.state = State.Static;
	}

	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = TargetX = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = TargetY = y;
	}

	public boolean isCanRemove() {
		return CanRemove;
	}
}
