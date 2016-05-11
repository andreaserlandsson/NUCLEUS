package com.nucleus.Adapters.Controllers;

import com.nucleus.Model.NucleusGame;
import com.nucleus.ThirdParty.libGDXControllers.NucleusGameCreator;

/**
 * Created by Quaxi on 11/05/16.
 */
public class GameControllerAdapter {

    private NucleusGameCreator gamelibGDX;
    private NucleusGame nucleusGame;

    public GameControllerAdapter(NucleusGameCreator gamelibGDX) {
        this.gamelibGDX = gamelibGDX;
        nucleusGame = new NucleusGame(this);


    }

    public void createGame(){
        //game = new NucleusGameCreator();
       // game.createGame();

    }

}
