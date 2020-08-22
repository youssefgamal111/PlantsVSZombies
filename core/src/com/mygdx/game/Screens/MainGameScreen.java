package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Levels.World;
import com.mygdx.game.PlantVsZombies;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainGameScreen implements Screen {
    private PlantVsZombies game;
    World w;
    Sound mgSound;

    public MainGameScreen(PlantVsZombies game,World W1) {
        this.game = game;
        w = W1;
        MainMenuScreen.bgSound.stop();
        mgSound = Gdx.audio.newSound(Gdx.files.internal("MainMenuScreen\\dayBG.wav"));
        mgSound.loop();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        try {
            w.Render();
        } catch (IOException ex) {
            Logger.getLogger(MainGameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
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
