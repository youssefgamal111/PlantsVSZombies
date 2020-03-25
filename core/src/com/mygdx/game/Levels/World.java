package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.mygdx.game.GameMap;
import com.mygdx.game.GameObjectFactory;
import com.mygdx.game.ImageFactory;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Plants.PeaShooter;

public abstract class World {
    public PlantVsZombies Game;
    GameMap Map;

    public World(PlantVsZombies game) {
        Game = game;
        ImageFactory.initialize(game);
        GameObjectFactory.initialize(game);
    }

    public Texture background;

    public void Render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Game.batch.begin();
        Game.batch.draw(background, 0, 0);
        ImageFactory.Render();
        GameObjectFactory.Render();
        Game.batch.end();
        if (Gdx.input.justTouched()) {
            ImageFactory.RenderTouch(Game.getInputInGameWorld());
            GameObjectFactory.AddPlant(new PeaShooter(0, 0), Map.findPlot(Game.getInputInGameWorld()));
        }


        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            GameObjectFactory.ShotTest();
        }
    }
}