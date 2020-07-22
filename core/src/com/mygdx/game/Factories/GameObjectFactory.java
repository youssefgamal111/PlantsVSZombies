package com.mygdx.game.Factories;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.*;
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
            if (obj instanceof Zombie) {
                ((Zombie) obj).StartAttack(null);
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
                    if (obj2.Row != gameObject.Row || obj2.getClass() == gameObject.getClass() || obj2.isCanRemove())
                        continue;
                    if (obj2 instanceof IAttacker) {
                        IAttacker attacker = (IAttacker) obj2;
                        if (attacker.CanAttack(gameObject)) {
                            IDamageable ToHit = (IDamageable) gameObject;
                            attacker.StartAttack(ToHit);
                            ToHit.ReceiveShot(attacker);
                        }
                    } else if (obj2 instanceof IDamageable) {
                        IAttacker attacker = (IAttacker) gameObject;
                        if (attacker.CanAttack(obj2)) {
                            IDamageable ToHit = (IDamageable) obj2;
                            attacker.StartAttack(ToHit);
                        }
                    }
                }
            }


        }
        GameObjects.addAll(GameObjectsToAdd);
        GameObjectsToAdd.clear();
    }

    public static void RenderTouch(Vector2 coords) {
        for (GameObject obj : GameObjects) {
            if (!(obj instanceof IClickable))
                continue;
            if (coords.x < obj.getX() + obj.getWidth() && coords.x > obj.getX() &&
                    coords.y < obj.getY() + obj.getHeight() && coords.y > obj.getY()) {
                ((IClickable) obj).OnClick();
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

