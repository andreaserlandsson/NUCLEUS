package com.nucleus.controller;

import com.badlogic.gdx.Gdx;
import com.nucleus.controller.controllerStates.ControllerState;
import com.nucleus.controller.controllerStates.InvertedPlayState;
import com.nucleus.controller.controllerStates.NormalPlayState;
import com.nucleus.views.libGDXGraphics.screens.PlayScreen;

public class GameInputHandler extends NInputProcessor {

    ControllerState normalGame;
    ControllerState currentState;
    ControllerState inverseGame;
    private PlayScreen screen;
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
        normalGame = new NormalPlayState(screen);
        inverseGame = new InvertedPlayState(screen);
        currentState = normalGame;
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
        if (currentState instanceof InvertedPlayState){
            Gdx.app.log("switchState", "Inverted");
            currentState = normalGame;
        }
        else if (currentState instanceof NormalPlayState){
            Gdx.app.log("switchState", "Normal");
            currentState = inverseGame;
        }
    }

    public ControllerState getState() {
        return currentState;
    }
}
