package com.nucleus.ThirdParty.libGDXControllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Adapters.Controllers.GameControllerAdapter;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.StartScreen;


public class NucleusGameCreator extends Game {

    GameControllerAdapter adapter;

    @Override
    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        adapter = new GameControllerAdapter(this);



        createGame();

    }

    public void createGame(){
        setScreen(new StartScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
