package com.mygdx.game.Images.Cards;

import com.mygdx.game.Plants.Plant;

public class Sunflower extends Card {
    public Sunflower() {
        super(50, 5, "Cards/sunflower.png");
    }

    @Override
    public Plant GetPlant() {
        return new com.mygdx.game.Plants.SunFlower(0, 0);
    }
}