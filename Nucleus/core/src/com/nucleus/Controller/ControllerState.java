package com.nucleus.Controller;

/**
 * Created by erik on 06/05/16.
 */
public interface ControllerState {
    void touch(int screenX, int screenY, int pointer, int button);
    void drag(int screenX, int screenY, int pointer); //temporary but probably incorrect argument
}
