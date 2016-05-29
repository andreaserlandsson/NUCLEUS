package com.nucleus.controller.controllerStates;

import com.nucleus.model.collision.Vector;
import com.nucleus.model.level.ILevel;
import com.nucleus.views.libGDXGraphics.screens.PlayScreen;

public class NormalPlayState implements com.nucleus.controller.controllerStates.ControllerState {

    private PlayScreen screen;
    Vector lastTouch = new Vector(0,0);

    public NormalPlayState(PlayScreen screen) {
        this.screen = screen;
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
