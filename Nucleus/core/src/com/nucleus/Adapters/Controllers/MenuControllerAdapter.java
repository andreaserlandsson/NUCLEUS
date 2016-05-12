package com.nucleus.Adapters.Controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;

import com.nucleus.ThirdParty.libGDXControllers.NInputAdapter;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.GameScreen;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Utils.LevelBuilder;

public class MenuControllerAdapter {

    public void changeLevel(int levelNum){

        Gdx.app.log("levelButton", "received");

        ILevel level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }
    
    public void startLevelChoose(int levelNum){

        ILevel level = LevelBuilder.buildLevel(1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }




}