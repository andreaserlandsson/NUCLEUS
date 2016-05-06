package com.nucleus.ThirdParty;

import com.nucleus.Controller.IController;
import com.nucleus.Model.Level;

import java.util.ArrayList;
import java.util.List;

public class InputAdapter extends NInputProcessor {

    Level level;
    List<IController> controllers = new ArrayList<IController>();
    IController activeController;


    public InputAdapter(com.nucleus.Model.Level level){
        this.level = level;;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
}
