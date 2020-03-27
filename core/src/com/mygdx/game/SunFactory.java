package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class SunFactory {
    private final static Texture SunCounter = new Texture(Gdx.files.internal("SunFactory/SunBack.png"));
    private final static BitmapFont font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
    private static int CollectedSuns;
    private static PlantVsZombies Game;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        Sun s = new Sun(300, 500);
        GameObjectFactory.AddGameObject(s);
        s.Move(300, 300);

    }

    public static void render() {
        Game.batch.draw(SunCounter, 110, 550);
        font.draw(Game.batch, String.valueOf(CollectedSuns), 160, 580);
    }
}

