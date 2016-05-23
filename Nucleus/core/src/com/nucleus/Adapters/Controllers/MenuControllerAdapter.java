package com.nucleus.Adapters.Controllers;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nucleus.Model.ILevel;

import com.nucleus.Controller.libGDXControllers.NInputAdapter;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.PauseDialog;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;
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
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen());
    }

    public void showPauseDialog(Stage stage2, SpriteBatch batch, ILevel level){
        Gdx.app.log("PauseDialog", "button pressed");
        Gdx.input.setInputProcessor(new NInputAdapter());
        ((Game)Gdx.app.getApplicationListener()).setScreen(new PauseDialog( batch, level));

    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }




}
