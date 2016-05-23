package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nucleus.Controller.NInputHandler;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;
import com.nucleus.Utils.LevelBuilder;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.PauseDialog;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;


public class NucleusGame extends Game {


    @Override
    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        goToStartScreen();
    }

    public void goToStartScreen(){
        Gdx.app.log("levelButton", "received");
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen());

    }

    public void goToLevel(int levelNum){

        Gdx.app.log("levelButton", "received");
        ILevel level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputHandler((Level) level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }

    public void goToLevelChooser(){
        ILevel level = LevelBuilder.buildLevel(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputHandler((Level) level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    public void showPauseDialog(SpriteBatch batch){
        Gdx.app.log("PauseDialog", "button pressed");
        Gdx.input.setInputProcessor(new NInputHandler());
        ((Game)Gdx.app.getApplicationListener()).setScreen(new PauseDialog());

    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
