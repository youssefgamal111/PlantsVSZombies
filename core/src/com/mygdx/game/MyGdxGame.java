package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	float elapsed;
	public ArrayList<GameObject> GameObjects;
	Zombie z;
	@Override
	public void create() {
		batch = new SpriteBatch();
		GameObjects = new ArrayList<GameObject>();
		 z = new Zombie(200,200);
		GameObjects.add(z);
	}

	@Override
	public void render() {
		elapsed += Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
			GameObject gameObject = iterator.next();
			batch.draw(gameObject.currentAnimation.getKeyFrame(elapsed), gameObject.X, gameObject.Y);
			gameObject.Render(Gdx.graphics.getDeltaTime());
			if (gameObject.CanRemove(elapsed))
				iterator.remove();
		}
		if(Gdx.input.isTouched())
		{
			//z.Move(Gdx.input.getX(), 500-Gdx.input.getY());
			z.Remove();
		}
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
