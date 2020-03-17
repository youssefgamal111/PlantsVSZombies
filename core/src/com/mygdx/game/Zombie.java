package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class Zombie extends GameObject {
	private Animation<TextureRegion> Walking, Attacking, Dying, Default;

	public Zombie(float x, float y) {
		super(x, y);
	}


	@Override
	public void Load() {
		Default = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("Zombie\\1.gif").read());
		Walking = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("Zombie\\Zombie.gif").read());
		Dying = GifDecoder.loadGIFAnimation(PlayMode.NORMAL, Gdx.files.internal("Zombie\\ZombieDie.gif").read());
		Attacking = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("Zombie\\ZombieAttack.gif").read());
		SetCurrentAnimation(Default);
		super.MoveSpeed = 10;

	}

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
