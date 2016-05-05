package com.nucleus;

public class InputController extends InputAdapter implements InputAdapterInterface{

    Level level;
    public InputController(Level level){
        this.level = level;
    }

    @Override
    public boolean keyDown(int x){
        System.out.println("rotating stuff");
        level.getMolecule().setRotation(1);
        return true;
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
