package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainMenuScreen;
import com.mygdx.game.PlantVsZombies;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 640;
		config.width=1080;
                 config.title="Plants Vs Zombies";
                 config.addIcon("plantsvszombies.png", Files.FileType.Internal);
		new LwjglApplication(new PlantVsZombies(), config);
	}
}
