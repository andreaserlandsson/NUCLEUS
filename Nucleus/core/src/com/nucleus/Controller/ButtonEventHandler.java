package com.nucleus.Controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.LevelPermissions;

/**
 * Created by Quaxi on 10/05/16.
 */
public class ButtonEventHandler extends ClickListener {

    private ApplicationController controller;

    public ButtonEventHandler(ApplicationController controller) {
        this.controller = controller;
    }

    public void clicked(InputEvent event, float x, float y) {

        String label = event.getTarget().toString();

        if (label.equals("Label: Play")) {
            controller.goToLevelChooser();
        }

        else if (label.equals("Label: Options")) {
            controller.goToOptions();
        }

        else if (label.equals("Label: Toggle Sound")){
            controller.toggleSound();
        }

        else if (label.equals("Label: Exit")) {
            controller.exit();
        }

        else if (label.equals("Label: Level 1")) {
            if(LevelPermissions.checkLevelPermission(1))
                controller.startLevel(1);
            else{

            }
        }

        else if (label.equals("Label: Level 2")) {
            if(LevelPermissions.checkLevelPermission(2))
                controller.startLevel(2);
            else{
                controller.showSelectionErrorDialog();
            }
        }

        else if (label.equals("Label: Level 3")) {
            if(true)//LevelPermissions.checkLevelPermission(3))
                controller.startLevel(3);
            else{
                controller.showSelectionErrorDialog();
            }
        }

        else if (label.equals("Label: OK")){
            controller.goToLevelChooser();
        }

        else if (label.equals("Label: Play Again")) {
            controller.restartLevel();
        }

        else if (label.equals("Label: Restart Level")) {
            controller.restartLevel();
        }

        else if (label.equals("Label: Continue")) {
            controller.resumeLevel();
        }

        else if (label.equals("Label: Main Menu")) {
            controller.goToStartScreen();
        }

        if (event.isHandled()) {
            controller.playClickSound();
        }

    }
}
