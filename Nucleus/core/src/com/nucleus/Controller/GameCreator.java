package com.nucleus.Controller;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by Quaxi on 11/05/16.
 */
public class GameCreator {


    public GameCreator(){
        create();
        setScreen("start");
    }

    private void create() {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "NucleusGame";
        config.width = 280;
        config.height = 512;
        config.samples = 4;
        new LwjglApplication(new NucleusGame(), config);
    }

    private void setScreen(String screen){

        if (screen.equals("start")){

        }
    };


}
