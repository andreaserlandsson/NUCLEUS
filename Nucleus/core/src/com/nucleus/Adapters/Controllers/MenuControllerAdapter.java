package com.nucleus.Adapters.Controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;

import com.nucleus.ThirdParty.libGDXControllers.NInputAdapter;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.GameScreen;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.ThirdParty.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Utils.LevelBuilder;
import com.nucleus.Views.StartScreenView;

public class MenuControllerAdapter {

    public void changeLevel(int levelNum){

        Gdx.app.log("levelButton", "received");

        ILevel level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }
    
    public void startLevelChoose(){

        ILevel level = LevelBuilder.buildLevel(1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    public void goToStartLevel(){
        Gdx.app.log("Main menu", "button pressed");

        StartScreenView ssv = new StartScreenView();
        Gdx.input.setInputProcessor(new NInputAdapter());
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen(ssv.getStartScreen()));
    }

    public void showPauseDialog(){
        Gdx.app.log("PauseDialog", "button pressed");

        
    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }




}
