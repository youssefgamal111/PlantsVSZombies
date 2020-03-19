package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Zombies.Zombie;

import java.util.ArrayList;

public class PlantVsZombies extends Game {

    public static final int WIDTH = 720;
    public static final int HEIGHT = 720;
    public static boolean IS_MOBILE = false;

    public SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();



        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

}
