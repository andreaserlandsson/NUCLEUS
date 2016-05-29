package com.nucleus.controller;

import com.nucleus.views.libGDXGraphics.Screens.PlayScreen;

public class GameInputHandler extends NInputProcessor {

    com.nucleus.controller.ControllerState controlGame;
    com.nucleus.controller.ControllerState currentState;
    com.nucleus.controller.ControllerState inverseGame;
    private PlayScreen screen;
    private boolean reverseState = false;
    private static GameInputHandler instance = null;

    private GameInputHandler(){
    }

    public static GameInputHandler getInstance() {
        if (instance == null){
            instance = new GameInputHandler();
        }
        return instance;
    }

    public void setScreen(PlayScreen screen) {
        this.screen = screen;
        setController();
    }

    private void setController() {
        controlGame = new com.nucleus.controller.NormalPlayState(screen);
        inverseGame = new InvertedPlayState(screen);
        currentState = controlGame;
        if (reverseState) {
            currentState = inverseGame;
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if ((screenX > screen.getWidth() - 50) && screenY < 68) { // if you touch the upper right corner you pause the game
            screen.getLevel().pause();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        currentState.drag(screenX, screenY, pointer);
        return true;
    }

    public void switchState(){
        reverseState = !reverseState;
    }
}
