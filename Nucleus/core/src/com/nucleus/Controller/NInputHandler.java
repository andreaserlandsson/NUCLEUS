package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;

import java.util.Observable;
import java.util.Observer;

public class NInputHandler extends NInputProcessor implements Observer {

    ControllerState controlGame;
    ControllerState currentState;
    ILevel level;

    public NInputHandler(Level level){
        this.level =  level;
        level.addObserver(this);
        controlGame = new PlayController(level);
        currentState = controlGame;
    }

    public NInputHandler(){

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        currentState.touch(screenX, screenY, pointer, button);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        currentState.drag(screenX, screenY, pointer);
        return true;
    }

    public void setState(ControllerState newState){
        currentState = newState;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("resume")){
            Gdx.app.log("Hejsan", "Stabben");
            Gdx.input.setInputProcessor(new NInputHandler((Level) level));
        }
    }
}
