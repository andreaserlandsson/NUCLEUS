package com.nucleus.Controller;

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
            controller.startLevelChoose(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){

        }

        if (event.getTarget().toString().equals("Label: Exit")){
            controller.exit();
        }

        if (event.getTarget().toString().equals("Label: Level 1")){
            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Level 2")){
            //DO STUFF
        }

        if (event.getTarget().toString().equals("Label: Level 2")){
            controller.exit();
        }

        if (event.getTarget().toString().equals("Label: Main Menu")){
            controller.startLevelChoose(1);
        }

        //win and lose screen
        if (event.getTarget().toString().equals("Label: Play Again")){
            controller.
        }

        if (event.getTarget().toString().equals("Label: Main Menu")){
            controller.startLevelChoose(1);
        }

    }
}
