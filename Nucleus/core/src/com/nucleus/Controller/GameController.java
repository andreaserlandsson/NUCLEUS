package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */
public class GameController extends ClickListener {

    private NucleusGame game;
    private NInputHandler controller;
    private IProgressTracker progressTracker;
    private INMusicPlayer musicPlayer;
    private GameScreen screen;

    public GameController() {
        game = new NucleusGame();
        controller = new NInputHandler(screen);
        progressTracker = new ProgressTracker();
        musicPlayer = NMusicPlayer.getInstance();
    }

    public void goToLevelChooser() {
        game.goToLevelChooser(this);
    }

    private void startLevel(int levelNum) {
        screen = new GameScreen(levelNum, this);
        Gdx.input.setInputProcessor(controller);
        Gdx.input.setInputProcessor(new NInputHandler(screen));
        game.goToScreen(screen);

    }

    private void resumeLevel(){
        Gdx.input.setInputProcessor(new NInputHandler(screen));
        screen.resume();
    }

    public void goToStartScreen(EventListener listener){
        game.goToStartScreen(this);
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
            if(progressTracker.checkLevelPermission(1))
                startLevel(1);
        }

        else if (label.equals("Label: Level 2")) {
            if(progressTracker.checkLevelPermission(2))
                startLevel(2);
        }

        else if (label.equals("Label: Play Again")) {
            goToLevelChooser();
        }

        else if (label.equals("Label: Main Menu")) {
            goToStartScreen(this);
        }

        else if (label.equals("Label: Continue Playing")) {
            Gdx.app.log("GameController Continue", "Received Input");
            resumeLevel();
        }


    }
}
