package com.nucleus.Controller;

import com.nucleus.Model.Vector;

import com.nucleus.Model.ILevel;
import com.nucleus.Model.Vector;

public class PlayController implements ControllerState {

    ILevel level;
    Vector lastTouch = new Vector(0,0);


    public PlayController(ILevel level){
        this.level = level;
    }

    public void touch(int screenX, int screenY, int pointer, int button){
        return;
    }

    public void drag(int screenX, int screenY, int pointer){
        Vector newTouch = new Vector(screenX, screenY);
        Vector delta = newTouch.subtract(this.lastTouch);
        level.getMolecule().setRotation(lastTouch, newTouch);
        this.lastTouch = newTouch;
        return;
    }

}
