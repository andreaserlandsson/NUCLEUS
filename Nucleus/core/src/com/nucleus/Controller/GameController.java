package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */
public class GameController extends ClickListener {

    private NucleusGame game;
    private NInputHandler controller;
    private INMusicPlayer musicPlayer;
    private GameScreen screen;

    public GameController() {
        game = new NucleusGame();
        controller = new NInputHandler(screen);
        musicPlayer = NMusicPlayer.getInstance();
    }

    public void goToLevelChooser() {
        game.goToLevelChooser(this);
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.MENUMUSIC);
    }

    private void startLevel(int levelNum) {
        screen = new GameScreen(levelNum, this);
        Gdx.input.setInputProcessor(controller);
        Gdx.input.setInputProcessor(new NInputHandler(screen));
        game.goToScreen(screen);

        //starting level music
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.getLevelSong(levelNum));

    }

    private void resumeLevel(){
        Gdx.input.setInputProcessor(new NInputHandler(screen));
        screen.getLevel().resume();
    }

    public void goToStartScreen(){
        game.goToStartScreen(this);
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.MENUMUSIC);
    }

    public void setInput(){

    }

    public void exit() {
        game.exit();
    }

    /**
     * Listens for inputs from buttons
     * @param event the evet that happend
     * @param x coordinate for the touch
     * @param y coordinate for the touch
     */
    public void clicked(InputEvent event, float x, float y) {

        String label = event.getTarget().toString();

        if (label.equals("Label: Play")) {
            goToLevelChooser();
        }

        else if (label.equals("Label: Options")) {
            game.goToOptions(this);
        }

        else if (label.equals("Label: Toggle Sound")){
            musicPlayer.setMasterVolume(1-musicPlayer.getMasterVolume());
        }

        else if (label.equals("Label: Exit")) {
            exit();
        }

        else if (label.equals("Label: Level 1")) {
            if(ProgressTracker.checkLevelPermission(1))
                startLevel(1);
        }

        else if (label.equals("Label: Level 2")) {
            if(ProgressTracker.checkLevelPermission(2))
                startLevel(2);
        }

        else if (label.equals("Label: Play Again")) {
            startLevel(screen.getLevel().getLevelNumber());
        }

        else if (label.equals("Label: Restart Level")) {
            startLevel(screen.getLevel().getLevelNumber());
        }

        else if (label.equals("Label: Continue")) {
            resumeLevel();
        }

        else if (label.equals("Label: Main Menu")) {
            goToStartScreen();
        }


        musicPlayer.playSound(NAssetsData.BUTTONCLICKEDSOUND    );

    }
}
