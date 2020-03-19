package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	public ArrayList<GameObject> GameObjects;
	@Override
	public void create() {
		batch = new SpriteBatch();
		GameObjects = new ArrayList<>();
		Zombie z = new NormalZombie(200, 200);
		Zombie y = new NormalZombie(400, 200);
		GameObjects.add(z);
		GameObjects.add(y);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//looping through all objects in the game
		for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
			GameObject gameObject = iterator.next();

			batch.draw(gameObject.GetCurrentFrame(), gameObject.X, gameObject.Y);
			gameObject.Render(Gdx.graphics.getDeltaTime());
			if (gameObject.CanRemove())
				iterator.remove();
		}
		//looping through all objects in the game
		if (Gdx.input.isTouched()) {
			for (GameObject z : GameObjects) {
				Zombie zz = (Zombie) z;
				zz.Move(Gdx.input.getX(), 500 - Gdx.input.getY());
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			for (GameObject z : GameObjects) {
				Zombie zz = (Zombie) z;
				zz.Kill();
			}
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
