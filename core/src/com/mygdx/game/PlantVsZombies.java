package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Screens.MainMenuScreen;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlantVsZombies extends Game {

    public static final int WIDTH = 1080;
    public static final int HEIGHT = 600;
    public OrthographicCamera gamecam;
    private Viewport gameport;
    public SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        gamecam = new OrthographicCamera();
        gameport = new ExtendViewport(WIDTH, HEIGHT, gamecam);
        gameport.apply();
        gamecam.position.set(WIDTH / 2, HEIGHT / 2, 0);
        gamecam.update();
        try {
            this.setScreen(new MainMenuScreen(this));
        } catch (IOException ex) {
            Logger.getLogger(PlantVsZombies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render () {
        batch.setProjectionMatrix(gamecam.combined);
        super.render();


    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width, height);
        super.resize(width, height);
    }

    public Vector2 getInputInGameWorld() {
        Vector3 inputScreen = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        Vector3 unprojected = gamecam.unproject(inputScreen);
        return new Vector2(unprojected.x, unprojected.y);
    }

}
