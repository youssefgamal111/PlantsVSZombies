package com.mygdx.game.Images.Cards;

import com.mygdx.game.Plants.Plant;

public class PeaShooter extends Card {
    public PeaShooter() {
        super(100, 5, "Cards/Peashooter.png");
    }

    @Override
    public Plant GetPlant() {
        return new com.mygdx.game.Plants.PeaShooter(0, 0);
    }
}
