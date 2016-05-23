package com.nucleus.Controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.ILevel;

/**
 * Created by Quaxi on 10/05/16.
 */

//TODO add listenerAdapter
public class MenuListener extends ClickListener {

    private MenuController controller;
    private ILevel level;

    public MenuListener() {
        this.controller = new MenuController();


    }
    public MenuListener(ILevel level) {
        this.controller = new MenuController();
        this.level = level;

    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")) {
            controller.startLevelChoose();
        }

        if (event.getTarget().toString().equals("Label: Options")) {
        }

        if (event.getTarget().toString().equals("Label: Exit")) {
            controller.exit();
        }

        if (event.getTarget().toString().equals("Label: Level 1")) {
            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Level 2")) {
            controller.changeLevel(2);
        }

        //win and lose screen
        if (event.getTarget().toString().equals("Label: Play Again")) {
            controller.changeLevel(level.getLevelNumber());
        }

        if (event.getTarget().toString().equals("Label: Main Menu")) {
            controller.goToStartScreen();
        }


    }
}
