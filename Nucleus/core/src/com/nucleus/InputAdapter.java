package com.nucleus;

public class InputAdapter extends NInputProcessor {

    Level level;
    public InputAdapter(Level level){
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
