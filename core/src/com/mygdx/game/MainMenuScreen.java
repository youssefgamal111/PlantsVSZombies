package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen, Input.TextInputListener {
    PlantVsZombies game;
    String text;
    private Texture BackGroundImg1 = new Texture(Gdx.files.internal("MainMenuScreen/Screenshot (234).png"));
    private Texture BackGroundImg2 = new Texture(Gdx.files.internal("MainMenuScreen/Screenshot (235).png"));
    private Texture Exit1 = new Texture(Gdx.files.internal("MainMenuScreen/Screenshot (245).png"));
    static Sound bgSound;
    public MainMenuScreen(PlantVsZombies game) {
        this.game = game;
         bgSound = Gdx.audio.newSound(Gdx.files.internal("MainMenuScreen\\intro.wav")); 
         bgSound.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        if (game.getInputInGameWorld().x > 500 && game.getInputInGameWorld().x < 1000 &&
                game.getInputInGameWorld().y < 640 - 50 && game.getInputInGameWorld().y > 640 - 200) {
            game.batch.draw(BackGroundImg2, 0, 0, 1080, 640);
            if (Gdx.input.isTouched()) {
                //   Gdx.input.getTextInput(this,"Title","Default text","");
                //   Gdx.app.log("Text",text);
                this.dispose();
                game.setScreen(new MainGameScreen(game));
                MainMenuScreen.bgSound.stop();
            }
        } else {
            game.batch.draw(BackGroundImg1, 0, 0, 1080, 640);
            if (game.getInputInGameWorld().x > 943 && game.getInputInGameWorld().x < 1050 &&
                    game.getInputInGameWorld().y < 640 - 470 && game.getInputInGameWorld().y > 640 - 590) {
                game.batch.draw(Exit1, 0, 0, 1080, 640);
                if (Gdx.input.isTouched()) {
                    game.dispose();
                    game.setScreen(new ExitScreen(game));
                }
            } else {
                game.batch.draw(BackGroundImg1, 0, 0, 1080, 640);
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

    @Override
    public void input(String text) {
        this.text = text;
    }

    @Override
    public void canceled() {
        text = "Cancelled";
    }
}