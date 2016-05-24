package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;


public class NucleusGame extends Game {


    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));
        GameController controller = new GameController();
        controller.setListener(new ButtonListener(controller));
        controller.goToStartScreen();

        INMusicPlayer musicPlayer;
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.loadMusic();
        musicPlayer.playMusic(NAssetsData.MENUMUSIC);
    }

    public void exit(){
        Gdx.app.exit();
    }

    @Override
    public void dispose(){
        super.dispose();
    }

}
