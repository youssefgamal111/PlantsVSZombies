package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

class Place {
    final int iX, iY, fX, fY, x, y;

    public Place(int x, int y, int iX, int iY, int fX, int fY) {
        this.x = x;
        this.y = y;
        this.iX = iX;
        this.iY = iY;
        this.fX = fX;
        this.fY = fY;
    }

}

public class GameMap {

    private final int NColumns = 9, Rows;
    private Place[][] map;
    public final static int[][] ColumnCords = {{245, 335}, {335, 410}, {410, 495}, {495, 575}, {575, 655}, {655, 735}, {735, 810}, {810, 900}, {900, 990}};
    public final static int[][] RowCords = {{30, 130}, {130, 220}, {220, 320}, {320, 420}, {420, 520}};

    public GameMap(int Rows) {
        this.Rows = 5;
        GenerateMap();
    }

    private void GenerateMap() {
        map = new Place[this.Rows][this.NColumns];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                //                    x  y       ix                iy                fx               fy
                map[i][j] = new Place(j, i, ColumnCords[j][0], RowCords[i][0], ColumnCords[j][1], RowCords[i][1]);
            }
        }
    }

    public Place findPlot(Vector2 coords) {
        return findPlot(coords.x, coords.y);
    }

    public Place findPlot(float x, float y) {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < NColumns; j++) {
                if (x > map[i][j].iX && x < map[i][j].fX && y > map[i][j].iY && y < map[i][j].fY) {
                    return map[i][j];
                }
            }
        }
        return null;
    }

    public int findRow(float x, float y) {
        Place result = findPlot(x, y);
        return result == null ? result.y : -1;
    }

}
