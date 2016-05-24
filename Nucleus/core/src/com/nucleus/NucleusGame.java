package com.nucleus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.Level;
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

    public void goToLevel(int levelNum, Level level){

        Gdx.app.log("levelButton", "received");
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }

    public void goToLevelChooser(){
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    public void showPauseDialog(SpriteBatch batch){
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
