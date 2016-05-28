package com.nucleus.Controller;

import com.nucleus.Views.libGDXGraphics.Screens.PlayScreen;

public class GameInputHandler extends NInputProcessor {

    ControllerState controlGame;
    ControllerState currentState;
    ControllerState inverseGame;
    private PlayScreen screen;

    public GameInputHandler(PlayScreen screen){
        this.screen = screen;
        controlGame = new NormalPlayState(screen);
        inverseGame = new InvertedPlayState(screen);
        currentState = controlGame;
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
            currentState = inverseGame;
            System.out.println("state är inverse");
        } else {
            currentState = controlGame;
            System.out.println("state är normal");
        }
    }
}
