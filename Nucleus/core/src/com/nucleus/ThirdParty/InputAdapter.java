package com.nucleus.ThirdParty;

import com.nucleus.Controller.ControllerState;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

public class InputAdapter extends NInputProcessor {

    ControllerState controlGame;
    ControllerState controlMenu;
    ControllerState controlPauseMenu;

    ControllerState currentState;

    ILevel level;


    public InputAdapter(ILevel level){
        this.level = level;
        controlGame = new GameController(level);
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
}
