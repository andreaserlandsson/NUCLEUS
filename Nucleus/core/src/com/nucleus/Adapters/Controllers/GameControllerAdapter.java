package com.nucleus.Adapters.Controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.NucleusGame;
import com.nucleus.ThirdParty.libGDXControllers.NInputAdapter;
import com.nucleus.ThirdParty.libGDXControllers.NucleusGameCreator;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.PauseDialog;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Views.StartScreenView;

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

    public void createGame(String [] buttons){
       gamelibGDX.createGame(buttons);

    }
}
