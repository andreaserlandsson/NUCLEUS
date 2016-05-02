package com.nucleus.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nucleus.NucleusGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NucleusGame";
		config.width = 300;
		config.height = 400;
		new LwjglApplication(new NucleusGame(), config);
	}
}
