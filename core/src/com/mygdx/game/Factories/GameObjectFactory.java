package com.mygdx.game.Factories;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameMap;
import com.mygdx.game.GameObject;
import com.mygdx.game.Place;
import com.mygdx.game.PlantVsZombies;
import com.mygdx.game.Plants.Bullet;
import com.mygdx.game.Plants.PeaShooter;
import com.mygdx.game.Plants.Plant;
import com.mygdx.game.Zombies.Zombie;

import java.util.ArrayList;
import java.util.Iterator;

public class GameObjectFactory {
    private static ArrayList<GameObject> GameObjects;
    private static ArrayList<GameObject> GameObjectsToAdd;
    private static PlantVsZombies Game;

    public static void initialize(PlantVsZombies game) {
        Game = game;
        GameObjects = new ArrayList<>();
        GameObjectsToAdd = new ArrayList<>();
    }

    public static void ShotTest() {
        for (GameObject obj : GameObjects) {
            if (obj instanceof PeaShooter) {
                ((PeaShooter) obj).Shot();
            }
        }

    }

    public static ArrayList<GameObject> getGameObjects() {
        return GameObjects;
    }

    public static ArrayList<GameObject> GetObjectsInRow(int row) {
        ArrayList<GameObject> result = new ArrayList<GameObject>();
        for (GameObject obj : GameObjects) {
            if (obj.Row == row)
                result.add(obj);
        }
        return result;
    }

    public static void Render() {
        for (Iterator<GameObject> iterator = GameObjects.iterator(); iterator.hasNext(); ) {
            GameObject gameObject = iterator.next();
            if (gameObject.CanRemove()) {
                iterator.remove();
                continue;
            }
            Game.batch.draw(gameObject.GetCurrentFrame(), gameObject.getX(), gameObject.getY());
            gameObject.Render();


            if (gameObject instanceof Zombie) {
                for (GameObject obj2 : GameObjects) {
                    if (obj2.Row != gameObject.Row || !(obj2 instanceof Bullet) || obj2.isCanRemove())
                        continue;
                    if (obj2.getX() > gameObject.getX() + gameObject.getWidth() - 120) {
                        Zombie ToHit = (Zombie) gameObject;
                        ToHit.ReceiveShot((Bullet) obj2);
                    }
                }
            }


        }
        GameObjects.addAll(GameObjectsToAdd);
        GameObjectsToAdd.clear();
    }

    public static void RenderTouch(Vector2 coords) {
        for (GameObject obj : GameObjects) {
            if (coords.x < obj.getX() + obj.getWidth() && coords.x > obj.getX() &&
                    coords.y < obj.getY() + obj.getHeight() && coords.y > obj.getY()) {
                obj.OnClick();
                return;
            }
        }
    }

    public static void AddZombie(Zombie z, int Row) {
        z.setX(GameMap.ColumnCords[GameMap.ColumnCords.length - 1][1] - z.getWidth() / 2);
        z.setY(GameMap.RowCords[Row][1] - z.getHeight() / 2);
        z.Move(0, z.getY());
        z.Row = Row;
        AddGameObject(z);
    }

    public static void AddPlant(Plant plant, Place place) {
        plant.setX(place.iX + 10);
        plant.setY(place.iY + plant.getHeight() / 2);
        plant.Row = place.y;
        place.setObj(plant);
        AddGameObject(plant);
    }

    public static void AddGameObject(GameObject p) {
        GameObjectsToAdd.add(p);
    }


}

