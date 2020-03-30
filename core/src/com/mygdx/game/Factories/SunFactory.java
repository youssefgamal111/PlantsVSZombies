package com.mygdx.game.Factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.FloatingSun;
import com.mygdx.game.Images.SunBackground;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Timers.DropSunTimer;

public class SunFactory {
   private final static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts\\FbUsv8C5eI.ttf.fnt"), false);
    private static final DropSunTimer timer = new DropSunTimer();
    private static int CollectedSuns;
    private static PlantVsZombies Game;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        ImageFactory.AddImage(new SunBackground());
        timer.Start();
    }

    public static void render() {
        font.draw(Game.batch, String.valueOf(CollectedSuns), 160, 580);
    }

    public static void DropSun() {
        int x = (int) ((Math.random() * ((350 - 200) + 1)) + 200);
        int y = (int) ((Math.random() * ((300 - 100) + 1)) + 100);
        FloatingSun s = new FloatingSun(x, 500);
        s.Move(x, y);
        GameObjectFactory.AddGameObject(s);
    }

    public static int getCollectedSuns() {
        return CollectedSuns;
    }

    public static void setCollectedSuns(int collectedSuns) {
        CollectedSuns = collectedSuns;
        ImageFactory.UpdateCards();

    }
}

