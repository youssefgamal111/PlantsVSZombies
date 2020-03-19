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
	private Rectangle rect;
	private boolean CanRemove;
	private float TargetX, TargetY, animationElapsedTime;
	private Animation<TextureRegion> currentAnimation;

	public GameObject(float moveSpeed, float x, float y) {
		MoveSpeed = moveSpeed;
		X = TargetX = x;
		Y = TargetY = y;
		CanRemove = false;
		//rect.setPosition(x,y);
		Load();
	}

	protected abstract void Load();

	protected abstract void OnRemove();

	protected abstract void OnMoveStart();

	protected abstract void OnMoveFinished();


	public void SetCurrentAnimation(Animation<TextureRegion> animation) {
		currentAnimation = animation;
		animationElapsedTime = 0f;
	}

	public TextureRegion GetCurrentFrame() {
		return currentAnimation.getKeyFrame(animationElapsedTime);
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
			X -= MoveSpeed * deltatime;
		if (X < TargetX)
			X += MoveSpeed * deltatime;
		if (Y > TargetY)
			Y -= MoveSpeed * deltatime;
		if (Y < TargetY)
			Y += MoveSpeed * deltatime;
		if (Math.abs(X - TargetX) < 1.2f)
			X = TargetX;
		if (Math.abs(Y - TargetY) < 1.2f)
			Y = TargetY;
		if (X == TargetX && Y == TargetY) {
			OnMoveFinished();
		}
	}
}
