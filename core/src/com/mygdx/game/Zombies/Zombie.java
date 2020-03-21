package com.mygdx.game.Zombies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Zombie extends GameObject {
	protected Animation<TextureRegion> Walking, Attacking, Dying, Default;

	public Zombie(int health,float moveSpeed, float x, float y) {
		super(health,moveSpeed, x, y);
	}


	@Override
    protected abstract void Load();

	public void Kill() {
		super.Remove();
	}

    @Override
    protected void OnRemove() {
        SetCurrentAnimation(Dying);
    }

    @Override
    protected void OnMoveFinished() {
        SetCurrentAnimation(Default);

    }

    @Override
    protected void OnMoveStart() {
        SetCurrentAnimation(Walking);

    }

}
