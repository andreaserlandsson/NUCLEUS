package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;
import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

import java.util.Observable;
import java.util.Observer;

public class NInputHandler extends NInputProcessor implements Observer {

    ControllerState controlGame;
    ControllerState currentState;
    private PlayScreen screen;

    public NInputHandler(PlayScreen screen){
        //level.addObserver(this);
        this.screen = screen;
        controlGame = new PlayController(screen);
        currentState = controlGame;
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
            Gdx.input.setInputProcessor(new NInputHandler(screen));
        }
    }
}
