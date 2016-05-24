package com.nucleus.Controller;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.Level;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;
import com.nucleus.Views.libGDXGraphics.Screens.LevelChooseScreen;
import com.nucleus.Views.libGDXGraphics.Screens.OptionsScreen;
import com.nucleus.Views.libGDXGraphics.Screens.StartScreen;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by Quaxi on 10/05/16.
 */
public class GameController extends ClickListener {

    private NucleusGame game;
    private NInputHandler controller;
    private INMusicPlayer musicPlayer;
    private Screen screen;
    private Level level;
    private int levelNum;

    public GameController() {
        game = new NucleusGame();
        controller = new NInputHandler((GameScreen) screen);
        musicPlayer = NMusicPlayer.getInstance();
    }

    public void goToLevelChooser() {
        screen = new LevelChooseScreen(this, 3);
        goToScreen(screen);

        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.MENUMUSIC);
    }

    private void startLevel(int levelNum) {

        this.level = LevelBuilder.buildLevel(levelNum, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ProgressTracker progressTracker = new ProgressTracker(level);
        this.levelNum = levelNum;
        screen = new GameScreen(level, this);
        Gdx.input.setInputProcessor(controller);
        Gdx.input.setInputProcessor(new NInputHandler((GameScreen) screen));
        goToScreen(screen);

        //starting level music
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.getLevelSong(levelNum));

    }

    private void resumeLevel(){
        Gdx.input.setInputProcessor(new NInputHandler((GameScreen) screen));
        level.resume();

    }

    public void goToStartScreen(){

        screen = new StartScreen(this);
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.MENUMUSIC);
        goToScreen(screen);

    }

    private void goToOptions() {
        screen = new OptionsScreen(this);
        goToScreen(screen);
    }

    private void goToScreen(Screen screen){
        Gdx.app.log("goToScreen", "accessed");
        ((Game)Gdx.app.getApplicationListener()).setScreen(screen);
    }


    private void restartLevel() {
        startLevel(levelNum);
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
            goToOptions();
        }

        else if (label.equals("Label: Toggle Sound")){
            musicPlayer.setMasterVolume(1-musicPlayer.getMasterVolume());
        }

        else if (label.equals("Label: Exit")) {
            exit();
        }

        else if (label.equals("Label: Level 1")) {
            if(LevelPermissions.checkLevelPermission(1))
                startLevel(1);
        }

        else if (label.equals("Label: Level 2")) {
            if(LevelPermissions.checkLevelPermission(2))
                startLevel(2);
        }

        else if (label.equals("Label: Play Again")) {
            restartLevel();
        }

        else if (label.equals("Label: Restart Level")) {
            resumeLevel();
        }

        else if (label.equals("Label: Continue")) {
            resumeLevel();
        }

        else if (label.equals("Label: Main Menu")) {
            goToStartScreen();
        }


        musicPlayer.playSound(NAssetsData.BUTTONCLICKEDSOUND);

    }
}
