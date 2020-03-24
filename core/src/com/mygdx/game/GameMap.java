package com.mygdx.game;
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
    private final static int[][] RowCords = {{245, 335}, {335, 410}, {410, 495}, {495, 575}, {575, 655}, {655, 735}, {735, 810}, {810, 900}, {900, 990}};
    private final static int[][] ColumnCords = {{30, 130}, {130, 220}, {220, 320}, {320, 420}, {420, 520}};

    public GameMap(int Rows) {
        this.Rows = 5;
        GenerateMap();
    }

    private void GenerateMap() {
        map = new Place[this.Rows][this.NColumns];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                //                    x   y     ix      iy              fx          fy
                map[i][j] = new Place(i, j, RowCords[j][0], ColumnCords[i][0], RowCords[j][1], ColumnCords[i][1]);
            }
        }
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
        return result == null ? result.x : -1;
    }

}
