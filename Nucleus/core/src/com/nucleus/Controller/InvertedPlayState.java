package com.nucleus.Controller;

import com.nucleus.Model.level.ILevel;
import com.nucleus.Model.Collisions.Vector;
import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

public class InvertedPlayState implements ControllerState {

    private PlayScreen screen;
    Vector lastTouch = new Vector(0,0);

    public InvertedPlayState(PlayScreen screen) {
        this.screen = screen;
    }

    public void drag(int screenX, int screenY, int pointer){
        ILevel level = screen.getLevel();
        Vector newTouch = new Vector(screenX, screenY);
        newTouch.subtract(this.lastTouch);
        level.getMolecule().setRotation(newTouch, lastTouch);
        this.lastTouch = newTouch;
        return;
    }
}
