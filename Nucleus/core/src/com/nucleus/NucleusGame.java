package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        Level level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        setScreen(new GameScreen(level));
        InputController r = new InputController(level);
        //TODO SKA DETA VARA EN INPUTADAPTER ELLER AV TYPEN INPUTCONTROLLER???
        Gdx.input.setInputProcessor(r);
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
