package com.nucleus.controller;

import com.badlogic.gdx.Gdx;
import com.nucleus.controller.controllerStates.ControllerState;
import com.nucleus.controller.controllerStates.InvertedPlayState;
import com.nucleus.controller.controllerStates.NormalPlayState;
import com.nucleus.views.libGDXGraphics.screens.PlayScreen;


/**
 * Handles all input directly related to playing the game
 */
public class GameInputHandler extends NInputProcessor {

    ControllerState normalGame;
    ControllerState currentState;
    ControllerState inverseGame;
    private PlayScreen screen;
    private static GameInputHandler instance = null;

    private GameInputHandler(PlayScreen screen){
        this.screen = screen;
        normalGame = new NormalPlayState(screen);
        inverseGame = new InvertedPlayState(screen);
        currentState = normalGame;
    }

    public static GameInputHandler getInstance(PlayScreen screen) {
        if (instance == null){
            instance = new GameInputHandler(screen);
        }
        return instance;
    }


    public void setScreen(PlayScreen screen) {
        this.screen = screen;
        normalGame.setScreen(screen);
        inverseGame.setScreen(screen);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if ((screenX > screen.getWidth() - 50) && screenY < 50) { // if you touch the upper right corner you pause the game
            screen.getLevel().pause();
        }


        //här är sköldknappen och aktiveringen
        if ((screen.getWidth()/2 - 20 < screenX) && (screenX < screen.getWidth()/2 + 20) && screenY < 40) { // if you touch the upper right corner you pause the game
            if (screen.getLevel().getShield().getCap() == 0 // sköldden måste vara borta inan man kan ta en ny
                    && screen.getLevel().getShield().getCharge() > 0) { // skölden måste ha "charges kvar"
                //från controller sätta värden i modell?!?!?!? som det gör nedan!
                screen.getLevel().getShield().setCap(5); // man får 5 chrages per gång
                screen.getLevel().getShield().decCharge();
            }
        }

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        currentState.drag(screenX, screenY, pointer);
        return true;
    }

    /**
     * Switches between inverted and normal controls
     */
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
