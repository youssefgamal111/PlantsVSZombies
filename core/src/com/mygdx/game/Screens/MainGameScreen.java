package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Levels.Level5;
import com.mygdx.game.Levels.World;
import com.mygdx.game.PlantVsZombies;


public class MainGameScreen implements Screen {
    private PlantVsZombies game;
    World w;
    Sound mgSound;

    public MainGameScreen(PlantVsZombies game) {
        this.game = game;
        w = new Level5(game);
        mgSound = Gdx.audio.newSound(Gdx.files.internal("MainMenuScreen\\dayBG.wav"));
        mgSound.loop();
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
