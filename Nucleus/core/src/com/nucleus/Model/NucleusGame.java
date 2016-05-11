package com.nucleus.Model;

import com.nucleus.Adapters.Controllers.GameControllerAdapter;
import com.nucleus.Controller.GameController;

/**
 * Created by Quaxi on 11/05/16.
 */
public class NucleusGame {

    private Level level;
    private GameControllerAdapter adapter;

    public NucleusGame(GameControllerAdapter gameControllerAdapter){
        adapter = gameControllerAdapter;
        adapter.createGame();
    }

}
