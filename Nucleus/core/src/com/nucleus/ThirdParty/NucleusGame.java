package com.nucleus.ThirdParty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Screens.StartScreen;

public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        setScreen(new StartScreen());
       // Gdx.input.setInputProcessor(new NInputProcessor());
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
