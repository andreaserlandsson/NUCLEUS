package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;


public class NucleusGame extends Game {


    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        ClickListener listener = new GameController();
        goToStartScreen(listener);

        INMusicPlayer musicPlayer;
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.loadMusic();
        musicPlayer.playMusic(NAssetsData.MENUMUSIC);
    }

    public void goToStartScreen(ClickListener listener){
        screen = new StartScreen(listener);
        Gdx.app.log("levelButton", "received");
        goToScreen(screen);
    }

    public void goToLevelChooser(ClickListener listener){
        screen = new LevelChooseScreen(listener, 3);
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
