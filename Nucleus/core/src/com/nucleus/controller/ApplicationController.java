package com.nucleus.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nucleus.model.level.Level;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.levelBuilder.LevelBuilder;
import com.nucleus.views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.views.libGDXGraphics.Screens.StartScreen;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;

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
        controller = GameInputHandler.getInstance((GameScreen) screen);
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
        //TODO: remove static reference?
        new ProgressTracker(level);
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

    public void showTextDialog(String text){
        if(screen instanceof DialogScreen){
            ((DialogScreen) screen).showTextDialog(text);
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
        Gdx.app.log("Rotation", "Reversed");
        showTextDialog("Rotation: " + controller.getState().toString());
    }
}
