package com.nucleus.Model;

import com.nucleus.Adapters.Controllers.GameControllerAdapter;
import com.nucleus.Views.StartScreenView;

/**
 * Created by Quaxi on 11/05/16.
 */
public class NucleusGame {

    private GameControllerAdapter adapter;
    private StartScreenView ssview;

    public NucleusGame(GameControllerAdapter gameControllerAdapter){
        ssview = new StartScreenView();
        adapter = gameControllerAdapter;
        adapter.createGame(ssview.getStartScreen());
    }

}
