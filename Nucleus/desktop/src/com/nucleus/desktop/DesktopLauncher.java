package com.nucleus.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nucleus.ThirdParty.libGDXControllers.NucleusGameCreator;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NucleusGame";
		config.width = 1920;
		config.height = 1024;
		new LwjglApplication(new NucleusGameCreator(), config);
	}
}
