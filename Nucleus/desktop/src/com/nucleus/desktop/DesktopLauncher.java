package com.nucleus.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nucleus.ThirdParty.libGDXControllers.NucleusGameCreator;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "NucleusGame";
		config.width = 1280;
		config.height = 720;
		config.samples = 4;
		new LwjglApplication(new NucleusGameCreator(), config);
	}
}
