/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Images.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Images.Image;

/**
 * @author USER
 */
public abstract class Card extends Image {

    /**
     * @return the y
     */

    private final int Price;
    private final TextureRegion selected, unselected;

    public Card(int Price, String path) {
        super(3, 0);
        this.Price = Price;
        Texture img = new Texture(Gdx.files.internal(path));
        selected = new TextureRegion(img, 0, 0, 100, 60);
        unselected = new TextureRegion(img, 0, 60, 100, 60);
        setImgTexture(unselected);
    }

    @Override
    protected void OnMoveStart() {

    }

    @Override
    protected void OnMoveFinished() {

    }

    @Override
    public void OnClick() {
        System.out.println("test");
    }

}
