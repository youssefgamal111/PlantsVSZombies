package com.mygdx.game.Zombies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Zombie extends GameObject {
	protected Animation<TextureRegion> Walking, Attacking, Dying, Default;

	public Zombie(float moveSpeed, float x, float y) {
		super(moveSpeed, x, y);
	}


	@Override
	public abstract void Load();

	public void Kill() {
		super.Remove();
	}

	@Override
	public void OnRemove() {
		SetCurrentAnimation(Dying);
	}

	@Override
	public void OnMoveFinished() {
		SetCurrentAnimation(Default);

	}

	@Override
	public void OnMoveStart() {
		SetCurrentAnimation(Walking);

	}

}
