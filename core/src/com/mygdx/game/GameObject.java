package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

import java.util.ArrayList;


public abstract class GameObject {
	private final float MoveSpeed;
	public float X, Y;
	public Rectangle rect;
	private boolean CanRemove;
	private float TargetX, TargetY, animationElapsedTime;
	private Animation<TextureRegion> currentAnimation;

	public GameObject(float moveSpeed, float x, float y) {
		MoveSpeed = moveSpeed;
		X = TargetX = x;
		Y = TargetY = y;
		CanRemove = false;
		rect = new Rectangle();
		rect.setPosition(X, Y);
		Load();
	}

	protected abstract void Load();

	protected abstract void OnRemove();

	protected abstract void OnMoveStart();

	protected abstract void OnMoveFinished();


	public void SetCurrentAnimation(Animation<TextureRegion> animation) {
		currentAnimation = animation;
		animationElapsedTime = 0f;
		rect.setWidth(getWidth());
		rect.setHeight(getHeight());

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
		this.CanRemove = true;
		OnRemove();
	}

	public boolean CanRemove() {
		return currentAnimation.isAnimationFinished(animationElapsedTime) && CanRemove;
	}

	public void Move(float x, float y) {
		if (MoveSpeed == 0)
			return;
		if (X == x && Y == y)
			return;
		TargetX = x;
		TargetY = y;
		OnMoveStart();
	}

	public void Render(float deltatime) {
		animationElapsedTime += deltatime;
		if (X == TargetX && Y == TargetY)
			return;
		if (X > TargetX)
			X = Math.max(X - MoveSpeed * deltatime, TargetX);
		if (X < TargetX)
			X = Math.min(X + MoveSpeed * deltatime, TargetX);
		if (Y > TargetY)
			Y = Math.max(Y - MoveSpeed * deltatime, TargetY);
		if (Y < TargetY)
			Y = Math.min(Y + MoveSpeed * deltatime, TargetY);
		rect.setPosition(X, Y);
		if (X == TargetX && Y == TargetY) {
			OnMoveFinished();
		}
	}
}
