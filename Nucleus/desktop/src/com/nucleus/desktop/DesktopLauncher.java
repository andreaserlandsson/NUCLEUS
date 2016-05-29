package com.nucleus.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nucleus.controller.NucleusGame;

public class DesktopLauncher {

	/**
	 * Initializes a game window
	 * @param arg
     */
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NucleusGame";
		config.width = 280;
		config.height = 512;
		config.samples = 4;
		new LwjglApplication(new NucleusGame(), config);
	}
}
