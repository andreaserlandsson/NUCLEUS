package com.nucleus.Controller;

import com.badlogic.gdx.Screen;
import com.nucleus.Model.Level;
import com.nucleus.Utils.Vector;
import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

public class PlayController implements ControllerState {

    private PlayScreen screen;

    public PlayController(PlayScreen screen) {
        this.screen = screen;
    }

    public void touch(int screenX, int screenY, int pointer, int button){
        if ((screenX > screen.getWidth() - 50) && screenY < 50) { // if you touch the upper right corner you pause the game
            screen.pause();
        }

        return;
    }

    public void drag(int screenX, int screenY, int pointer){
        screen.drag(screenX, screenY, pointer);
        return;
    }
}
