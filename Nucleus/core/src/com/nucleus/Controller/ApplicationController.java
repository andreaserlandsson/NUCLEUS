package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nucleus.Model.level.Level;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.LevelBuilder.LevelBuilder;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by Quaxi on 24/05/16.
 */
public class ApplicationController {


    private ButtonEventHandler listener;
    private GameInputHandler controller;
    private INMusicPlayer musicPlayer;
    private Screen screen;
    private Level level;

    public ApplicationController() {
        controller = GameInputHandler.getInstance();
        controller.setScreen((GameScreen) screen);
        musicPlayer = NMusicPlayer.getInstance();
    }

    public void setListener(ButtonEventHandler listener) {
        this.listener = listener;
    }

    public void goToLevelChooser() {
        screen = new LevelChooseScreen(listener, 3);
        goToScreen(screen);
    }

    public void startLevel(int levelNum) {

        this.level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ProgressTracker progressTracker = new ProgressTracker(level);
        screen = new GameScreen(level, listener);
        Gdx.input.setInputProcessor(controller);
        controller.setScreen((GameScreen)screen);
        goToScreen(screen);

        //starting level music
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.getLevelSong(levelNum));

    }

    protected void resumeLevel(){
        Gdx.input.setInputProcessor(controller);
        //controller.setScreen();
        level.resume();
    }

    protected void goToStartScreen(){
        this.level = LevelBuilder.buildLevel(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        screen = new StartScreen(listener,level);
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.MENUMUSIC);
        goToScreen(screen);

    }

    public void showSelectionErrorDialog(){
        if(screen instanceof LevelChooseScreen){
            ((LevelChooseScreen) screen).showSelectionError();
        }
    }

    protected void goToOptions() {
        screen = new OptionsScreen(listener);
        goToScreen(screen);
    }

    private void goToScreen(Screen screen){
        Gdx.app.log("goToScreen", "accessed");
        ((Game)Gdx.app.getApplicationListener()).setScreen(screen);
    }

    protected void restartLevel() {
        startLevel(level.getLevelNumber());
    }

    public void exit() {
        Gdx.app.exit();
    }

    public void toggleSound() {
        musicPlayer.setMasterVolume(1-musicPlayer.getMasterVolume());
    }

    public void playClickSound() {
        musicPlayer.playSound(NAssetsData.BUTTONCLICKEDSOUND);
    }

    public void reverseRotation() {
        controller.switchState();
        System.out.println("är jag här?");
    }
}
