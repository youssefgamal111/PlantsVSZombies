package com.mygdx.game;

public class Place {
    final int iX, iY, fX, fY, x, y;


    private GameObject obj;

    public Place(int x, int y, int iX, int iY, int fX, int fY) {
        this.x = x;
        this.y = y;
        this.iX = iX;
        this.iY = iY;
        this.fX = fX;
        this.fY = fY;
        obj = null;
    }

    public GameObject getObj() {
        return obj;
    }

    public void setObj(GameObject obj) {
        this.obj = obj;
    }
}
