package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.Level;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Utils.LevelUtils.LevelBuilder;
import com.nucleus.Views.LevelPermissions;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */
public class ButtonListener extends ClickListener {

    private GameController controller;

    public ButtonListener(GameController controller) {
        this.controller = controller;
    }

    /**
     * Listens for inputs from buttons
     * @param event the evet that happend
     * @param x coordinate for the touch
     * @param y coordinate for the touch
     */
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
        }

        else if (label.equals("Label: Level 2")) {
            if(LevelPermissions.checkLevelPermission(2))
                controller.startLevel(2);
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

        controller.playClickSound();
    }
}
