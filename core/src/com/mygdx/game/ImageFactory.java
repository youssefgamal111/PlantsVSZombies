package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Image;

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
        int y = 75 * (Images.size() + 1);
        Card.setY(y);
        Images.add(Card);

    }
}
      
  
 
    

