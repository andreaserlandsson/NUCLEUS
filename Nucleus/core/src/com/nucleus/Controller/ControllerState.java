package com.nucleus.Controller;


public interface ControllerState {
    void touch(int screenX, int screenY, int pointer, int button);
    void drag(int screenX, int screenY, int pointer);

}
