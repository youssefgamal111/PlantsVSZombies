package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.PlantVsZombies;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = PlantVsZombies.HEIGHT;
		config.width = PlantVsZombies.WIDTH;
		config.title = "Plants Vs Zombies";
		config.addIcon("plantsvszombies.png", Files.FileType.Internal);
		new LwjglApplication(new PlantVsZombies(), config);
	}
}
