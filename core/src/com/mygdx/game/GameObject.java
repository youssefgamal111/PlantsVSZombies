package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class GameObject {
	public float MoveSpeed;
	float X, Y;
	float TargetX, TargetY;
	private boolean CanRemove;
	public Animation<TextureRegion> currentAnimation;

	public GameObject() {
		CanRemove = false;
		Load();
	}

	public abstract void Load();
	public abstract void OnRemove();

	public abstract void OnMoveStart();

	public abstract void OnMoveFinished();

	public void Remove() {
		this.CanRemove = true;
		OnRemove();
	}

	public boolean CanRemove(float time) {
		if (currentAnimation.isAnimationFinished(time) && CanRemove) {
			return true;
		}
		return false;
	}

	public void Move(int x, int y) {

		if (X == x && Y == y)
			return;
		TargetX = x;
		TargetY = y;
		OnMoveStart();
	}

	public void Render(float deltatime) {
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
