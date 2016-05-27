package com.nucleus.Controller;

import com.nucleus.Model.Collisions.Vector;
import com.nucleus.Model.level.ILevel;
import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

public class NormalPlayState implements ControllerState {

    private PlayScreen screen;
    Vector lastTouch = new Vector(0,0);

    public NormalPlayState(PlayScreen screen) {
        this.screen = screen;
    }

    public void touch(int screenX, int screenY, int pointer, int button){

        if ((screenX > screen.getWidth() - 50) && screenY < 68) { // if you touch the upper right corner you pause the game
            screen.getLevel().pause();
        }

    }

    public void drag(int screenX, int screenY, int pointer){
        ILevel level = screen.getLevel();
        Vector newTouch = new Vector(screenX, screenY);
        newTouch.subtract(this.lastTouch);
        level.getMolecule().setRotation(lastTouch, newTouch);
        this.lastTouch = newTouch;
        return;
    }
}
