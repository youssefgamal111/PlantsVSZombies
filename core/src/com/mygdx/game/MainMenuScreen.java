package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
    PlantVsZombies game;
    private Texture BackGroundImg1 = new Texture(Gdx.files.internal("Screenshot (234).png"));
    private Texture BackGroundImg2 = new Texture(Gdx.files.internal("Screenshot (235).png"));
    public MainMenuScreen(PlantVsZombies game)
    {
        this.game=game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        if(Gdx.input.getX() > 500 && Gdx.input.getX() < 1000 && Gdx.input.getY() > 50 && Gdx.input.getY() < 200) {
            game.batch.draw(BackGroundImg2, 0, 0, 1080, 640);
            if (Gdx.input.isTouched())
            {
                this.dispose();
                game.setScreen(new MainGameScreen(game));
            }
        }
        else {
            game.batch.draw(BackGroundImg1, 0, 0, 1080, 640);
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

    }
}
