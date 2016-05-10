package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Quaxi on 10/05/16.
 */
public class MenuListener extends ClickListener {

    private MenuController controller;

    public MenuListener() {
        this.controller = new MenuController();
    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("playButton", "clicked");
            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("optionsButton", "clicked");
        }

        if (event.getTarget().toString().equals("Label: Exit")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("exitButton", "clicked");
            controller.exit();
        }
    }
}
