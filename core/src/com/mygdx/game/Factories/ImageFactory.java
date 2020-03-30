package com.mygdx.game.Factories;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Images.Cards.Card;
import com.mygdx.game.Images.Image;
import com.mygdx.game.PlantVsZombies;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author USER
 */
public class ImageFactory {
    private static PlantVsZombies Game;
    private static ArrayList<Image> Images;
    private static ArrayList<Image> ImagesToAdd;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        Images = new ArrayList<>();
        ImagesToAdd = new ArrayList<>();
    }

    public static void Render() {
        for (Iterator<Image> iterator = Images.iterator(); iterator.hasNext(); ) {
            Image img = iterator.next();
            img.Render();
            Game.batch.draw(img.getImgTexture(), img.getX(), img.getY());
            if (img.isCanRemove())
                iterator.remove();
        }
        Images.addAll(ImagesToAdd);
        ImagesToAdd.clear();
    }

    public static void RenderTouch(Vector2 coords) {
        for (int i = 0; i < Images.size(); i++) {
            Image img = Images.get(i);
            if (img.rect.contains(coords)) {
                img.OnClick();
                return;
            }
        }
    }

    public static void AddCard(Card Card) {
        int y = PlantVsZombies.HEIGHT - (75 * (Images.size() + ImagesToAdd.size()));
        Card.setY(y);
        Card.Update();
        ImagesToAdd.add(Card);

    }

    public static void AddImage(Image img) {
        ImagesToAdd.add(img);

    }

    public static void UpdateCards() {
        for (Image img : Images) {
            if (!(img instanceof Card))
                continue;
            Card c = (Card) img;
            c.Update();
        }
    }
}
      
  
 
    

