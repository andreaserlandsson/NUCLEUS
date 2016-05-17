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

        Gdx.app.log("level1Button", "received");

        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), levelNum);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(level));

    }
    
    public void startLevelChoose(int levelNum){

        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    public void goToStartLevel(){
        Gdx.app.log("Main menu", "button pressed");

        StartScreenView ssv = new StartScreenView();
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen(ssv.getStartScreen()));
    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }




}
