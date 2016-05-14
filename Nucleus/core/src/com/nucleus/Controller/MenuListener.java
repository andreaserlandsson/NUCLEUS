package com.nucleus.Controller;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.NMusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */

//TODO add listenerAdapter
public class MenuListener extends ClickListener {

    private NMusicPlayer musicPlayer;
    private MenuController controller;

    public MenuListener() {
        this.controller = new MenuController();
        this.musicPlayer = NMusicPlayer.getInstance();
    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")){
            //musicPlayer.playSound(NMusicPlayer.buttonClick);
           // musicPlayer.stop(NMusicPlayer.menu);
            controller.startLevelChoose(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){
           // musicPlayer.pause(NMusicPlayer.menu);



        }

        if (event.getTarget().toString().equals("Label: Exit")){
           // musicPlayer.playSound(NMusicPlayer.buttonClick);
            controller.exit();
        }

        if (event.getTarget().toString().equals("Label: Level 1")){
           // musicPlayer.playSound(NMusicPlayer.buttonClick);

            controller.changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Level 2")){
            controller.changeLevel(2);
        }

    }
}
