/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author USER
 */
public abstract class Card {

    /**
     * @return the y
     */
   
  private final String path;
   private final int price;
 private final int x=145;
 private int y;
   private TextureRegion selected,unselected,current;
    public Card(int price,String path) {
        this.price = price;
        this.path=path;
        this.Load();
    }
   
  
   private void Load(){
    
     Texture img;
    img=new Texture(Gdx.files.internal(path));
  selected=new TextureRegion(img, 0, 0,100 ,60);
     unselected=new TextureRegion(img, 0, 60,100 ,60);
        setCurrent(unselected);
    
    
    
    }
 public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the current
     */
    public TextureRegion getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(TextureRegion current) {
        this.current = current;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    
}
