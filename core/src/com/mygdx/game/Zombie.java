package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class Zombie extends GameObject {
	public Animation<TextureRegion> Walking,Attacking, Dying, Default;

	public Zombie(int x, int y) {
		X = TargetX = x;
		Y = TargetY = y;
	}

	@Override
	public void Load() {
		Default = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("1.gif").read());
		Walking = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("Zombie.gif").read());
		Dying = GifDecoder.loadGIFAnimation(PlayMode.NORMAL, Gdx.files.internal("ZombieDie.gif").read());
		Attacking = GifDecoder.loadGIFAnimation(PlayMode.LOOP, Gdx.files.internal("ZombieAttack.gif").read());
		currentAnimation = Default;
		super.MoveSpeed = 10;

	}

	@Override
	public void OnRemove() {
		currentAnimation =  Dying;
	}

	@Override
	public void OnMoveFinished() {
		currentAnimation = Default;
	}

	@Override
	public void OnMoveStart() {
		currentAnimation = Walking;
	}

}
