package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class ExitScreen implements Screen {
    PlantVsZombies game;
    private Texture Exit2 = new Texture(Gdx.files.internal("Screenshot (247).png"));
    private Texture Exit3 = new Texture(Gdx.files.internal("Screenshot (248).png"));
    private Texture Exit4 = new Texture(Gdx.files.internal("Screenshot (249).png"));

    public ExitScreen(PlantVsZombies game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Exit2, 0, 0, 1080, 640);
        if(Gdx.input.getX() > 300 && Gdx.input.getX() < 515 && Gdx.input.getY() > 400 && Gdx.input.getY() < 445)
        {
            game.batch.draw(Exit3, 0, 0, 1080, 640);
            if (Gdx.input.isTouched())
            {
                this.dispose();
                game.batch.end();
            }
        }
        else if(Gdx.input.getX() > 535 && Gdx.input.getX() < 750 && Gdx.input.getY() > 400 && Gdx.input.getY() < 445)
        {
            game.batch.draw(Exit4, 0, 0, 1080, 640);
            if (Gdx.input.isTouched())
            {
                this.dispose();
                game.setScreen(new MainMenuScreen(game));
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

    }
}
