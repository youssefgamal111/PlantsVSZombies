package com.mygdx.game.Images.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.SelectionHandler;
import com.mygdx.game.Factories.SunFactory;
import com.mygdx.game.Images.Image;
import com.mygdx.game.Plants.Plant;

public abstract class Card extends Image {

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
        if (SunFactory.getCollectedSuns() >= this.Price)
            SelectionHandler.SelectedCard = this;
    }

    public abstract Plant GetPlant();

    public void Update() {
        if (SunFactory.getCollectedSuns() >= this.Price)
            setImgTexture(selected);
        else
            setImgTexture(unselected);
    }

    public int getPrice() {
        return Price;
    }
}
