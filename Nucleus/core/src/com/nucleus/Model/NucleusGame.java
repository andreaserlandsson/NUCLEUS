package com.nucleus.Model;

import com.nucleus.Adapters.Controllers.GameControllerAdapter;
import com.nucleus.Views.StartScreenView;

/**
 * Created by Quaxi on 11/05/16.
 */
public class NucleusGame {

    private GameControllerAdapter adapter;

    public NucleusGame(GameControllerAdapter gameControllerAdapter){
        adapter = gameControllerAdapter;
        adapter.createGame(new String[] {"Play", "Options", "Exit"});
    }

}
