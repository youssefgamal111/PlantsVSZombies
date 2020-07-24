package com.mygdx.game.Screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Levels.*;
import com.mygdx.game.Levels.World;
import com.mygdx.game.PlantVsZombies;

public class MainLevelScreen implements Screen  {

    PlantVsZombies game;
    private Texture Main = new Texture(Gdx.files.internal("MainMenuScreen/levels.png"));
    private Texture Exit = new Texture(Gdx.files.internal("MainMenuScreen/levels-exit.png"));
    World W;
    public MainLevelScreen(PlantVsZombies game) {
        this.game = game;
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float f) {
      Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Main, 0, 0, 1080, 640);
         if (game.getInputInGameWorld().x > 943 && game.getInputInGameWorld().x < 1050 &&
                    game.getInputInGameWorld().y < 640 - 470 && game.getInputInGameWorld().y > 640 - 590) 
            {
                game.batch.draw(Exit, 0, 0, 1080, 640);
                if (Gdx.input.isTouched()) 
                {
                    game.dispose();
                    game.setScreen(new ExitScreen(game));
                }
            }
         else if (game.getInputInGameWorld().x > 590 && game.getInputInGameWorld().x < 920 &&
                    game.getInputInGameWorld().y < 550  && game.getInputInGameWorld().y > 500 ) 
                {
                    if (Gdx.input.isTouched())
                {
                    game.dispose();
                     W= new Level1(game);
                    game.setScreen(new MainGameScreen(game,W));
                }
                }
         else if (game.getInputInGameWorld().x > 590 && game.getInputInGameWorld().x < 920 &&
                    game.getInputInGameWorld().y < 480  && game.getInputInGameWorld().y > 423 ) 
         {
                if (Gdx.input.isTouched()) 
                {
                    game.dispose();
                     W= new Level2(game);
                    game.setScreen(new MainGameScreen(game,W));
                }
         }
         else if (game.getInputInGameWorld().x > 590 && game.getInputInGameWorld().x < 920 &&
                    game.getInputInGameWorld().y < 410  && game.getInputInGameWorld().y > 350 ) {
                if (Gdx.input.isTouched()) 
                {
                    game.dispose();
                     W= new Level3(game);
                    game.setScreen(new MainGameScreen(game,W));
                }
         }
         else if (game.getInputInGameWorld().x > 590 && game.getInputInGameWorld().x < 920 &&
                    game.getInputInGameWorld().y < 330  && game.getInputInGameWorld().y > 270 ) {
                if (Gdx.input.isTouched()) 
                {
                    game.dispose();
                     W= new Level4(game);
                    game.setScreen(new MainGameScreen(game,W));
                }
         }
         else if (game.getInputInGameWorld().x > 590 && game.getInputInGameWorld().x < 920 &&
                    game.getInputInGameWorld().y < 260  && game.getInputInGameWorld().y > 200 ) {
                if (Gdx.input.isTouched()) 
                {
                    game.dispose();
                     W= new Level5(game);
                    game.setScreen(new MainGameScreen(game,W));
                }
         }
         
        game.batch.end();

    }

    @Override
    public void resize(int i, int i1) {
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
