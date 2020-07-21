package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Factories.*;
import com.mygdx.game.GameMap;
import com.mygdx.game.Place;
import com.mygdx.game.PlantVsZombies;

public abstract class World {
    private PlantVsZombies Game;
    GameMap Map;

    public World(PlantVsZombies game) {
        Game = game;
        TimerFactory.initialize();
        ImageFactory.initialize(game);
        GameObjectFactory.initialize(game);
        SunFactory.initialize(game);
    }

    public Texture background;

    public void Render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Game.batch.begin();
        Game.batch.draw(background, 0, 0);
        ImageFactory.Render();
        GameObjectFactory.Render();
        SunFactory.render();
        Game.batch.end();
        TimerFactory.Render();

        if (Gdx.input.justTouched()) {
            ImageFactory.RenderTouch(Game.getInputInGameWorld());
            GameObjectFactory.RenderTouch(Game.getInputInGameWorld());
            Place place = Map.findPlot(Game.getInputInGameWorld());
            SelectionHandler.RenderTouch(place);
            //  if (place != null && place.getObj() == null)
            //      GameObjectFactory.AddPlant(new PeaShooter(0, 0), place);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            GameObjectFactory.ShotTest();
        }
    }
}