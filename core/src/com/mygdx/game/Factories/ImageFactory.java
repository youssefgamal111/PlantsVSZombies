package com.mygdx.game.Factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Images.Cards.Card;
import com.mygdx.game.Images.Image;
import com.mygdx.game.PlantVsZombies;

import java.util.ArrayList;
import java.util.Iterator;

public class ImageFactory {
    private final static BitmapFont font = new BitmapFont(Gdx.files.internal("fonts\\javaprices.fnt"), false);
    private static PlantVsZombies Game;
    private static ArrayList<Image> Images;
    private static ArrayList<Image> ImagesToAdd;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        Images = new ArrayList<>();
        ImagesToAdd = new ArrayList<>();
    }

    public static void Render() {int counter=1;
        for (Iterator<Image> iterator = Images.iterator(); iterator.hasNext(); ) {
            Image img = iterator.next();
            img.Render();
            Game.batch.draw(img.getImgTexture(), img.getX(), img.getY());
            if(img instanceof Card){ font.draw(Game.batch, String.valueOf(((Card) img).getPrice()), img.getX()+70, img.getY()+20);}
            if (img.isCanRemove())
                iterator.remove();
        }
        Images.addAll(ImagesToAdd);
        ImagesToAdd.clear();
    }

    public static void RenderTouch(Vector2 coords) {
        for (int i = 0; i < Images.size(); i++) {
            Image img = Images.get(i);
            if (img.getRect().contains(coords)) {
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
      
  
 
    

