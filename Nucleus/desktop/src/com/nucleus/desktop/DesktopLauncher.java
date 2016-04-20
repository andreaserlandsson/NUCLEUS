package com.nucleus.desktop;


import com.NucleusView;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Nucleus";
		config.width = 540;
		config.height = 960;
		new LwjglApplication(new NucleusView(), config);
	}
}
