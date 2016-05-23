package com.nucleus.Controller.libGDXControllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Adapters.Controllers.GameControllerAdapter;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;


public class NucleusGame extends Game {


    @Override
    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        setScreen(new StartScreen());

    }

    public void startScreen(){
        setScreen(new StartScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
