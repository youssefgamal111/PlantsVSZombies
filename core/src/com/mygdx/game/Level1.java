package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Cards.puffshroom;

public class Level1 extends World {
    public Level1(PlantVsZombies game) {
        super(game);
        this.background = new Texture("background1.jpg");
        this.Map = new GameMap(5);
        LoadObjects();
    }

    private void LoadObjects() {
        GameObjectFactory.AddZombie(0);
        ImageFactory.AddCard(new puffshroom());
    }
}
