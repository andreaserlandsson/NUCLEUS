package com.nucleus.Controller.libGDXControllers;

import com.nucleus.Controller.ControllerState;
import com.nucleus.Controller.PlayController;
import com.nucleus.Controller.MenuController;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;

public class NInputAdapter extends NInputProcessor {

    ControllerState controlGame;
    MenuController controlMenu;
    ControllerState controlPauseMenu;

    ControllerState currentState;

    ILevel level;

    public NInputAdapter(ILevel level){
        this.level = level;
        controlGame = new PlayController((Level) level);
        currentState = controlGame;
    }

    public NInputAdapter(){
        controlMenu = new MenuController();

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
