package com.nucleus.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nucleus.NucleusGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NucleusGame";
		config.width = 288;
		config.height = 512;
		new LwjglApplication(new NucleusGame(), config);
	}
}
