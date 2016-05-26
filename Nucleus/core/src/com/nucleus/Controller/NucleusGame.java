package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.AssetHandler.Assets;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;


public class NucleusGame extends Game {


    public void create(){

        Gdx.app.log("NucleusGame", "created");
        Gdx.app.log("Height", Integer.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("Width", Integer.toString(Gdx.graphics.getWidth()));

        Assets.loadTextureFiles();
        Assets.loadTextFiles();

        ApplicationController controller = new ApplicationController();
        controller.setListener(new ButtonEventHandler(controller));
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
