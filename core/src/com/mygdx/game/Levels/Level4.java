package com.mygdx.game.Levels;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Factories.GameObjectFactory;
import com.mygdx.game.Factories.ImageFactory;
import com.mygdx.game.GameMap;
import com.mygdx.game.Images.Cards.PeaShooter;
import com.mygdx.game.Images.Cards.Repeater;
import com.mygdx.game.Images.Cards.Sunflower;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Plants.LawnCleaner;
import com.mygdx.game.Timers.ZombieGeneratorTimer;
import com.mygdx.game.Zombies.NormalZombie;

public class Level4 extends World {
    private ZombieGeneratorTimer timer;

    public Level4(PlantVsZombies game) {
        super(game);
        this.background = new Texture("background1.jpg");
        this.Map = new GameMap(5);
        GameObjectFactory.setMap(Map);

        timer = new ZombieGeneratorTimer(4f);
        LoadObjects();
        ImageFactory.UpdateCards();

    }

    private void LoadObjects() {
        GameObjectFactory.AddZombie(new NormalZombie(0, 0), 2);
        timer.Start();
        ImageFactory.AddCard(new PeaShooter());
        ImageFactory.AddCard(new Sunflower());
        ImageFactory.AddCard(new Repeater());

        int[][] rowCords = GameMap.RowCords;
        for (int i = 0; i < rowCords.length; i++) {
            int[] cord = rowCords[i];
            GameObjectFactory.AddGameObject(new LawnCleaner(185, cord[0], i));
        }
    }
}
