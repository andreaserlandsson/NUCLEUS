package com.nucleus.Controller;

import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

public class GameInputHandler extends NInputProcessor {

    ControllerState controlGame;
    ControllerState currentState;
    ControllerState inverseGame;
    ControllerState tempState;
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
        controlGame = new NormalPlayState(screen);
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
        if (currentState == controlGame) {
            this.currentState = new InvertedPlayState(screen);
            reverseState = true;
            System.out.println("state är inverse");
        } else {
            this.currentState = new NormalPlayState(screen);
            reverseState = false;

            System.out.println("state är normal");
        }
    }
}
