package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

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
        }
    }
}