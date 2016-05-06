package com.nucleus.ThirdParty;

public class InputAdapter extends NInputProcessor {

    com.nucleus.Model.Level level;
    public InputAdapter(com.nucleus.Model.Level level){
        this.level = level;
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
