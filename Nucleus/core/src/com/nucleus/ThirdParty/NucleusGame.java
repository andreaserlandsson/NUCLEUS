package com.nucleus.ThirdParty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Screens.StartScreen;
import com.nucleus.Utils.LevelBuilder;
import com.nucleus.Screens.GameScreen;


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
