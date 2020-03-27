package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import javax.swing.text.View;

public class SunFactory {
private final Texture SunCounter;

private SpriteBatch batch;
private BitmapFont font ;
private int CollectedSuns;
Sun sun;

    public SunFactory() {
        CollectedSuns=0;
        batch= new SpriteBatch();
        sun=new Sun(30,300,500);
        font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
        this.SunCounter= new Texture(Gdx.files.internal("SunFactory/SunBack.png"));
    }
public void render()
  {
    batch.begin();
    batch.draw(SunCounter, 110, 550);
    font.draw(batch, String.valueOf(CollectedSuns), 160,580);
    sun.Render(1f);
    sun.Move(300, 300);
    batch.end();
  }
}

class Sun extends GameObject{
private final Animation FloatingSun;
    public Sun(float moveSpeed, float x, float y) {
        super(moveSpeed, x, y);
        this.FloatingSun = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("SunFactory/Sun.gif").read());
    }

    @Override
    protected void Load() {
        SetCurrentAnimation(FloatingSun);
    }

    @Override
    protected void OnRemove() {
        Stop();

    }

    @Override
    protected void OnMoveStart() {
    }

    @Override
    protected void OnMoveFinished() {
        SetCurrentAnimation(FloatingSun);

    }
    
}