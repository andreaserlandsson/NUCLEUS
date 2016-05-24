package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.Level;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.Views.libGDXGraphics.Screens.PauseDialog;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;


public class NucleusGame extends Game {


    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        ClickListener listener = new GameController();
        goToStartScreen(listener);
    }

    public void goToStartScreen(ClickListener listener){
        Gdx.app.log("levelButton", "received");
        ((Game)Gdx.app.getApplicationListener()).setScreen(new StartScreen(listener));

    }

    public void goToLevel(int levelNum, Level level){

        Gdx.app.log("levelButton", "received");
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(levelNum, level));

    }

    public void goToLevelChooser(ClickListener listener){
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen(listener));

    }

    public void goToOptions(){
        ((Game)Gdx.app.getApplicationListener()).setScreen(new OptionsScreen());
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
