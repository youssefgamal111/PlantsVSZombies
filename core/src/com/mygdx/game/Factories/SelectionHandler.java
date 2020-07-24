package com.mygdx.game.Factories;

import com.mygdx.game.Images.Cards.Card;
import com.mygdx.game.Place;
import com.mygdx.game.Plants.Plant;

public class SelectionHandler {
    private static Card SelectedCard;


    private static void Render(Place p) {
        if (SelectedCard == null || p == null)
            return;

    }

    public static void RenderTouch(Place place) {
        if (SelectedCard == null)
            return;
        if (place == null || place.getObj() != null)
            return;
        if (!SelectedCard.CanUse())
            return;
        Plant plant = SelectedCard.GetPlant();
        plant.setX(place.iX + 10);
        plant.setY(place.iY + plant.getHeight() / 2);
        plant.Row = place.y;
        plant.Column = place.x;
        place.setObj(plant);
        GameObjectFactory.AddGameObject(plant);
        SunFactory.setCollectedSuns(SunFactory.getCollectedSuns() - SelectedCard.getPrice());
        SelectedCard = null;

    }

    public static Card getSelectedCard() {
        return SelectedCard;
    }

    public static void setSelectedCard(Card selectedCard) {
        SelectedCard = selectedCard;
    }
}
