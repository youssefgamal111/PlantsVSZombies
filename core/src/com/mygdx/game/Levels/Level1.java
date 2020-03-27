package com.mygdx.game.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.Factories.ImageFactory;
import com.mygdx.game.GameMap;
import com.mygdx.game.Images.Cards.PuffShroom;
import com.mygdx.game.Images.LawnCleaner;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Zombies.NormalZombie;

public class Level1 extends World {
    public Level1(PlantVsZombies game) {
        super(game);
        this.background = new Texture("background1.jpg");
        this.Map = new GameMap(5);
        LoadObjects();
    }

    private void LoadObjects() {
        GameObjectFactory.AddZombie(new NormalZombie(0, 0), 2);
        ImageFactory.AddCard(new PuffShroom());
        for (int[] cord : GameMap.RowCords) {
            ImageFactory.AddImage(new LawnCleaner(185, cord[0]));
        }
    }
}
