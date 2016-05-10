package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Quaxi on 10/05/16.
 */
public class LevelMenuListener extends ClickListener {

    private LevelMenuController controller;

    public LevelMenuListener() {
        this.controller = new LevelMenuController();
    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Level 1")){
            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){

            //DO STUFF
        }

        if (event.getTarget().toString().equals("Label: Exit")){
            controller.exit();
        }
    }
}
