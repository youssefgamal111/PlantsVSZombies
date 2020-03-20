package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Plants.Pea;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;

import java.util.ArrayList;
import java.util.Iterator;

public class MainGameScreen implements Screen {
    private PlantVsZombies game;
    private static ArrayList<GameObject> GameObjects;
    private static ArrayList<GameObject> GameObjectsToAdd = new ArrayList<>();
    private float time;
    private TextureRegion backgroundTexture;

    public static void AddGameObject(GameObject go) {
        GameObjectsToAdd.add(go);
    }

    public MainGameScreen(PlantVsZombies game) {
        this.game = game;
        backgroundTexture = new TextureRegion(new Texture("background1unsodded1.jpg"), 0, 0, PlantVsZombies.WIDTH, PlantVsZombies.HEIGHT);
        GameObjects = new ArrayList<>();
        Zombie z = new NormalZombie(200, 200);
        Zombie y = new NormalZombie(500, 200);
        Plant p = new PeaShooter(10, 10);
        GameObjects.add(z);
        // GameObjects.add(y);
        // GameObjects.add(p);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        time += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0);
        //I believe texture region takes the upper left corner as 0,0 and batch.Draw the bottom left.
        //So you might need to do something like this:
        for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject gameObject = iterator.next();

            game.batch.draw(gameObject.GetCurrentFrame(), gameObject.X, gameObject.Y);
            gameObject.Render(Gdx.graphics.getDeltaTime());
            if (gameObject.CanRemove())
                iterator.remove();
        }
        GameObjects.addAll(GameObjectsToAdd);
        GameObjectsToAdd.clear();
        //looping through all objects in the game
        if (Gdx.input.isTouched()) {
            for (GameObject z : GameObjects) {
                if (z instanceof Zombie)
                    z.Move(game.getInputInGameWorld().x, game.getInputInGameWorld().y);
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
        for (int i = 0; i < GameObjects.size(); i++) {
            GameObject x = GameObjects.get(i);
            if (x instanceof Pea) {
                for (GameObject y : GameObjects) {
                    if (y instanceof Zombie) {
                        if (x.rect.overlaps(y.rect)) {
                            System.out.println("OVERLAPS");
                        }
                    }
                }
            }
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.batch.dispose();
    }
}
