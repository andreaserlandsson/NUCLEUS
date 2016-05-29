package com.nucleus.controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.views.LevelPermissions;

/**
 * Listens to all buttons and delegates it to the ApplicationController
 */
public class ButtonEventHandler extends ClickListener {
    private final int LEVELSTRINGINDEX = 13;
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

        else if (label.equals("Label: OK")){
            controller.goToLevelChooser();
        }

        else if (label.equals("Label: Play Again") || label.equals("Label: Restart Level")) {
            controller.restartLevel();
        }

        else if (label.equals("Label: Continue")) {
            controller.resumeLevel();
        }

        else if (label.equals("Label: Main Menu")) {
            controller.goToStartScreen();
        }

        else if (label.startsWith("Label: Level ")) {
            controller.startLevel(Integer.parseInt(label.substring(LEVELSTRINGINDEX)));
        }

        else if (label.equals("Label: Reverse Rotation")) {
            controller.reverseRotation();
        }

        if (event.isHandled()) {
            controller.playClickSound();
        }

    }
}
