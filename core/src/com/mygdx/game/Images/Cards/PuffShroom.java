package com.mygdx.game.Images.Cards;

import com.mygdx.game.Plants.Plant;

public class PuffShroom extends Card {
    public PuffShroom() {
        super(0, "Cards/puffshroom.png");
    }

    @Override
    public Plant GetPlant() {
        return new com.mygdx.game.Plants.PuffShroom(0, 0);
    }
}