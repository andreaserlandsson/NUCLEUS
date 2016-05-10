package com.nucleus.ThirdParty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Utils.LevelBuilder;
import com.nucleus.Screens.GameScreen;


public class NucleusGame extends Game {

    @Override
    public void create(){
        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        setScreen(new GameScreen(level));
        Gdx.input.setInputProcessor(new NInputAdapter(level));

    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
