package com.mygdx.game.Zombies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public abstract class Zombie extends GameObject {
	protected Animation<TextureRegion> Walking, Attacking, Dying, Default;
private int health;
	public Zombie(float moveSpeed, float x, float y,int health) {
		super(moveSpeed, x, y);
		this. health=health;
	}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
