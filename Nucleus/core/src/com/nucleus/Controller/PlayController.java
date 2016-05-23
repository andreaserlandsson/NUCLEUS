package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.nucleus.Controller.libGDXControllers.NInputAdapter;
import com.nucleus.Model.Level;
import com.nucleus.Model.Vector;

import com.nucleus.Model.ILevel;
import com.nucleus.Model.Vector;

import java.util.Observable;
import java.util.Observer;

public class PlayController implements ControllerState, Observer {

    Level level;
    Vector lastTouch = new Vector(0,0);

    public PlayController(Level level) {
        this.level = level;
        level.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("resume")){
            Gdx.app.log("Hejsan", "Stabben");
            Gdx.input.setInputProcessor(new NInputAdapter(level));
        }
    }

    public void pause(){

    }

}
