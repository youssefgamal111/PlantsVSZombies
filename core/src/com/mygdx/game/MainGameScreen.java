package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Levels.Level1;
import com.mygdx.game.Levels.World;

public class MainGameScreen implements Screen {
    private PlantVsZombies game;
    World w;

    public MainGameScreen(PlantVsZombies game) {
        this.game = game;
        w = new Level1(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        w.Render();
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
