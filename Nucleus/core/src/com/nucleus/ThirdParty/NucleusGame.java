package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        com.nucleus.Model.Level level = com.nucleus.Utils.LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        setScreen(new StartScreen());
        //TODO SKA DETA VARA EN INPUTADAPTER ELLER AV TYPEN INPUTCONTROLLER???
        Gdx.input.setInputProcessor(new NInputProcessor());
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
