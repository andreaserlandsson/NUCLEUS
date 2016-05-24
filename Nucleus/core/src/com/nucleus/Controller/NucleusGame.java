package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
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
        screen = new StartScreen(listener);
        Gdx.app.log("levelButton", "received");
        goToScreen(screen);
    }

    public void goToLevelChooser(ClickListener listener){
        screen = new LevelChooseScreen(listener);
        goToScreen(screen);
    }

    public void goToOptions(ClickListener listener){
        screen = new OptionsScreen(listener);
        goToScreen(screen);
    }

    public void goToScreen(Screen screen){
        Gdx.app.log("goToScreen", "accessed");
        ((Game)Gdx.app.getApplicationListener()).setScreen(screen);
    }

    public void exit(){
        Gdx.app.exit();
    }

    @Override
    public void dispose(){
        super.dispose();
    }




}
