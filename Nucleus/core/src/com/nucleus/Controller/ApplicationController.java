package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nucleus.Model.Level;
import com.nucleus.Views.NAssetsData;
import com.nucleus.Model.LevelUtils.LevelBuilder;
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


    private NucleusGame game;
    private ButtonEventHandler listener;
    private GameInputHandler controller;
    private INMusicPlayer musicPlayer;
    private Screen screen;
    private Level level;

    public ApplicationController() {
        game = new NucleusGame();
        controller = new GameInputHandler((GameScreen) screen);
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
        //this.levelNum = levelNum;
        screen = new GameScreen(level, listener);
        Gdx.input.setInputProcessor(controller);
        Gdx.input.setInputProcessor(new GameInputHandler((GameScreen) screen));
        goToScreen(screen);

        //starting level music
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.getLevelSong(levelNum));

    }

    protected void resumeLevel(){
        Gdx.input.setInputProcessor(new GameInputHandler((GameScreen) screen));
        level.resume();
    }

    protected void goToStartScreen(){

        screen = new StartScreen(listener);
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
        game.exit();
    }

    public void toggleSound() {
        musicPlayer.setMasterVolume(1-musicPlayer.getMasterVolume());
    }

    public void playClickSound() {
        musicPlayer.playSound(NAssetsData.BUTTONCLICKEDSOUND);

    }
}
