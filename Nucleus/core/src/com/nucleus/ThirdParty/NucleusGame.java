package com.nucleus.ThirdParty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.Level;
import com.nucleus.Screens.GameScreen;
import com.nucleus.Utils.LevelBuilder;

public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        Level level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        setScreen(new GameScreen(level));
        //TODO SKA DETA VARA EN INPUTADAPTER ELLER AV TYPEN INPUTCONTROLLER???
        Gdx.input.setInputProcessor(new InputAdapter(level));
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
