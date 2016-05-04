package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        setScreen(new StartScreen());
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
