package com.nucleus.controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.nucleus.assetHandler.Assets;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.levelBuilder.LevelBuilder;
import com.nucleus.model.level.Level;
import com.nucleus.views.LevelPermissions;
import com.nucleus.views.libGDXGraphics.screens.DialogScreen;
import com.nucleus.views.libGDXGraphics.screens.GameScreen;
import com.nucleus.views.libGDXGraphics.screens.LevelChooseScreen;
import com.nucleus.views.libGDXGraphics.screens.OptionsScreen;
import com.nucleus.views.libGDXGraphics.screens.StartScreen;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;


/**
 * Handles all non-game related user input, such as menus and music.
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
        screen = new LevelChooseScreen(listener, Assets.getLevelAmount());
        goToScreen(screen);
    }

    /**
     * Starts a new level
     * @param levelNum is an integer of the level number
     */
    public void startLevel(int levelNum) {
        if (LevelPermissions.checkLevelPermission(levelNum)) {
            this.level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            new ProgressTracker(level);
            screen = new GameScreen(level, listener);
            Gdx.input.setInputProcessor(controller);
            controller.setScreen((GameScreen)screen);
            goToScreen(screen);

            //starting level music
            musicPlayer = NMusicPlayer.getInstance();
            musicPlayer.switchSong(NAssetsData.getLevelSong(levelNum));
        } else {
            showTextDialog("Level Not Unlocked");
        }
    }


    protected void resumeLevel(){
        Gdx.input.setInputProcessor(controller);
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
        showTextDialog("Sound " + musicPlayer.getSoundOff());
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
