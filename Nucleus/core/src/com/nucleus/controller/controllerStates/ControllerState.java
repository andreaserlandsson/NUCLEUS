package com.nucleus.controller.controllerStates;


import com.nucleus.views.libGDXGraphics.screens.PlayScreen;

public interface ControllerState {
    void drag(int screenX, int screenY, int pointer);
    void setScreen(PlayScreen screen);
    String toString();

}
