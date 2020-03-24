package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Zombies.NormalZombie;
import com.mygdx.game.Zombies.Zombie;

import java.util.ArrayList;
import org.graalvm.compiler.lir.alloc.lsra.Interval;

public class GameMap {

    int Rows, Coloumns;
    static ArrayList<GameObject> GameObjects;
    TextureRegion backgroundTexture;
    place[][] map;

    ShapeRenderer s = new ShapeRenderer();

    public GameMap(int Rows, int Coloumns) {
        this.Rows = 5;
        this.Coloumns = 9;
        backgroundTexture = new TextureRegion(new Texture("background1.jpg"), 0, 0, PlantVsZombies.WIDTH, PlantVsZombies.HEIGHT);
        CreateMap();

    }
    
    void CreateMap() {
        map = new place[this.Rows][this.Coloumns];
        final int[][] Row = {{245,335},{335,410},{410,495},{495,575},{575,655},{655,735},{735,810},{810,900},{900,990}};
        final int[][] Coloumn={{30,130},{130,220},{220,320},{320,420},{420,520}};
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                //                    x   y     ix      iy              fx          fy
                map[i][j] = new place(i , j , Row[j][0], Coloumn[i][0], Row[j][1], Coloumn[i][1]);
            }
        }

    }

    public void findPlot(float x, float y) {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Coloumns; j++) {
                if (x > map[i][j].iX && x < map[i][j].fX) {
                    if (y > map[i][j].iY && y < map[i][j].fY) {
                        System.out.println(map[i][j].x + " " + map[i][j].y);
                        return;
                    }
                }
            }
        }
    }

}

class place {

    int iX, iY, fX, fY, x, y;

    public place(int x, int y, int iX, int iY, int fX, int fY) {
        this.x = x;
        this.y = y;
        this.iX = iX;
        this.iY = iY;
        this.fX = fX;
        this.fY = fY;
    }

}
