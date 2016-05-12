package com.nucleus.Controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.ThirdParty.libGDXControllers.MusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */

//TODO add listenerAdapter
public class MenuListener extends ClickListener {

    private MusicPlayer music;
    private MenuController controller;

    public MenuListener() {
        this.controller = new MenuController();
        this.music = MusicPlayer.getInstance();
    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")){
            music.playSound(music.buttonClicked);
            controller.startLevelChoose(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){
            music.playSound(music.buttonClicked);


        }

        if (event.getTarget().toString().equals("Label: Exit")){
            music.playSound(music.buttonClicked);
            controller.exit();
        }

        if (event.getTarget().toString().equals("Label: Level 1")){
            music.playSound(music.buttonClicked);

            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Level 2")){
            controller.changeLevel(2);
        }

    }
}
