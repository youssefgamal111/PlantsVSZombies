package com.mygdx.game.Images.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Factories.SelectionHandler;
import com.mygdx.game.Factories.SunFactory;
import com.mygdx.game.Images.Image;
import com.mygdx.game.Plants.Plant;

public abstract class Card extends Image {

    private final int Delay;
    private final int Price;
    private final TextureRegion selected, unselected;
    private long LastUse = 0;

    public Card(int Price, int Delay, String path) {
        super(3, 0);
        this.Price = Price;
        this.Delay = Delay;
        Texture img = new Texture(Gdx.files.internal(path));
        selected = new TextureRegion(img, 0, 0, 100, 60);
        unselected = new TextureRegion(img, 0, 60, 100, 60);
        setImgTexture(unselected);
    }

    @Override
    public void Render() {
        super.Render();

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
            SelectionHandler.setSelectedCard(this);
    }

    public boolean CanUse() {
        if (((System.currentTimeMillis() - LastUse) / 1000) >= Delay) {
            LastUse = System.currentTimeMillis();
            return true;
        }
        return false;
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
