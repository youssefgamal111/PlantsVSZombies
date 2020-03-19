package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private static ArrayList<GameObject> GameObjects;
	private static ArrayList<GameObject> GameObjectsToAdd = new ArrayList<>();
	private float time;

	public static void AddGameObject(GameObject go) {
		GameObjectsToAdd.add(go);
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		GameObjects = new ArrayList<>();
		Zombie z = new NormalZombie(200, 200);
		Zombie y = new NormalZombie(400, 200);
		Plant p = new PeaShooter(10, 10);
		GameObjects.add(z);
		GameObjects.add(y);
		GameObjects.add(p);


	}

	@Override
	public void render() {
		time += Gdx.graphics.getDeltaTime();
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
		GameObjects.addAll(GameObjectsToAdd);
		GameObjectsToAdd.clear();
		//looping through all objects in the game
		if (Gdx.input.isTouched()) {
			for (GameObject z : GameObjects) {
				z.Move(Gdx.input.getX(), 500 - Gdx.input.getY());
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			for (GameObject z : GameObjects) {
				if (z instanceof Zombie) {
					Zombie zz = (Zombie) z;
					zz.Kill();
				}
			}
		}
		if (time > 1f) {
			for (GameObject z : GameObjects) {
				if (z instanceof PeaShooter) {
					PeaShooter zz = (PeaShooter) z;
					zz.Shot();
				}
			}
			time = 0;
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
