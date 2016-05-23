package com.nucleus.Adapters.Controllers;

import com.nucleus.Controller.GameController;

/**
 * Created by Quaxi on 11/05/16.
 */
public class GameControllerAdapter {

    private com.nucleus.Controller.libGDXControllers.NucleusGame gamelibGDX;
    private GameController nucleusGame;

    public GameControllerAdapter(com.nucleus.Controller.libGDXControllers.NucleusGame gamelibGDX) {
        this.gamelibGDX = gamelibGDX;
        nucleusGame = new GameController();
    }

    public void createGame(String [] buttons){
       gamelibGDX.startScreen();

    }
}
