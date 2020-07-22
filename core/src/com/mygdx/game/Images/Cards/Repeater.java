package com.mygdx.game.Images.Cards;

import com.mygdx.game.Plants.Plant;

public class Repeater extends Card {
    public Repeater() {
        super(150, "Cards/Repeater.png");
    }

    @Override
    public Plant GetPlant() {
        return new com.mygdx.game.Plants.Repeater(0, 0);
    }
}
