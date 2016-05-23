package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nucleus.Controller.MenuController;
import com.nucleus.Controller.libGDXControllers.NInputAdapter;
import com.nucleus.Model.ILevel;
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
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }

    public void goToLevelChooser(){
        ILevel level = LevelBuilder.buildLevel(1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    public void goToStartLevel(){
        Gdx.app.log("Main menu", "button pressed");
        Gdx.input.setInputProcessor(new NInputAdapter());
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen());
    }

    public void showPauseDialog(SpriteBatch batch){
        Gdx.app.log("PauseDialog", "button pressed");
        Gdx.input.setInputProcessor(new NInputAdapter());
        ((Game)Gdx.app.getApplicationListener()).setScreen(new PauseDialog(batch));

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
