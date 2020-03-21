package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Plants.Pea;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;
import java.awt.Label;

import java.util.ArrayList;
import java.util.Iterator;

public class MainGameScreen implements Screen {
    BitmapFont scorefont;
    private PlantVsZombies game;
    private static ArrayList<GameObject> GameObjects;
    private static ArrayList<GameObject> GameObjectsToAdd = new ArrayList<>();
    private float time;
    private TextureRegion backgroundTexture;
int score;
    public static void AddGameObject(GameObject go) {
        GameObjectsToAdd.add(go);
    }

    public MainGameScreen(PlantVsZombies game) {
       scorefont=new BitmapFont(Gdx.files.internal("font.fnt"));
       score=0;
        this.game = game;
        backgroundTexture = new TextureRegion(new Texture("background1unsodded1.jpg"), 0, 0, PlantVsZombies.WIDTH, PlantVsZombies.HEIGHT);
        GameObjects = new ArrayList<>();
        Zombie z = new NormalZombie(1020, 220);
        Zombie y = new NormalZombie(500, 200);
        Plant p = new PeaShooter(10, 10);
        Plant a = new PeaShooter(10, 10);
        Plant b = new PeaShooter(10, 10);
        Plant c = new PeaShooter(10, 10);
        Plant d = new PeaShooter(10, 10);
        
        GameObjects.add(z);
        GameObjects.add(a);
        GameObjects.add(b);
        GameObjects.add(c);
        GameObjects.add(d);
        z.Move(0,220);
        // GameObjects.add(y);
         GameObjects.add(p);
         p.X=50;
         a.X=80;
         b.X=110;
         c.X=140;
         d.X=170;
         p.Y=a.Y=b.Y=c.Y=0;
                 d.Y=250;
         
                 
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        time += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0);
        //I believe texture region takes the upper left corner as 0,0 and batch.Draw the bottom left.
        //So you might need to do something like this:
        GlyphLayout scorelayout=new GlyphLayout(scorefont,"score  "+score+" ");
        scorefont.draw(game.batch, scorelayout,Gdx.graphics.getWidth()-scorelayout.width ,Gdx.graphics.getHeight()-scorelayout.height-8);
        for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject gameObject = iterator.next();

            game.batch.draw(gameObject.GetCurrentFrame(), gameObject.X, gameObject.Y);
            gameObject.Render(Gdx.graphics.getDeltaTime());
            if (gameObject.CanRemove())
                iterator.remove();
        }
        GameObjects.addAll(GameObjectsToAdd);
        GameObjectsToAdd.clear();
        //looping through all objects in the game
        

//        if (Gdx.input.isTouched()) {
//            for (GameObject z : GameObjects) {
//                if (z instanceof Zombie)
//                    z.Move(game.getInputInGameWorld().x, game.getInputInGameWorld().y);                    z.Move(game.getInputInGameWorld().x, game.getInputInGameWorld().y);
//                    z.Move(0, 220);
//
//            }
//        }

        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            for (GameObject z : GameObjects) {
                if (z instanceof Zombie) {
                    Zombie zz = (Zombie) z;
                    zz.Kill();
                }
            }
        }
         
        if (time > 1f) {
            for (GameObject z : GameObjects) {
                if (z instanceof PeaShooter) {
                    if(((PeaShooter) z).shoot==false){
                       PeaShooter zz = (PeaShooter) z;
                    ((PeaShooter) z).pea=zz.Shot();
                    ((PeaShooter) z).shoot=true;
                    }
                    
                }
            }
            time = 0;
        }
       
        for (int i = 0; i < GameObjects.size(); i++) {
            GameObject x = GameObjects.get(i);
            if (x instanceof Pea) {
                for (GameObject y : GameObjects) {
                    if (y instanceof Zombie) {
                        if (x.rect.overlaps(y.rect)) {
                            System.out.println("OVERLAPS");
                            ((Zombie) y).health-=20;
                        }
                        if(((Zombie) y).health>=0)
                        {
                            ((Zombie) y).Kill();
//                            y=new NormalZombie(1020, 220);
//                            GameObjects.add(y);
//                            y.Move(0,220);

                        }
                    }
                }
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
        game.batch.dispose();
    }
   
}
