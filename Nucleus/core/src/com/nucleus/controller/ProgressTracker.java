package com.nucleus.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.nucleus.model.level.ILevel;
import com.nucleus.model.level.Level;
import com.nucleus.model.nucleusObservers.IObservable;
import com.nucleus.model.nucleusObservers.IObserver;

/**
 * Tracks the users progress
 */
public class ProgressTracker implements IObserver<Level.GameState> {
    private static Preferences prefs = Gdx.app.getPreferences("prefs");

    public ProgressTracker(IObservable level){
        level.addObserver(this);
    }

    private int readCompletedLevels(){
        int lvlProgress = prefs.getInteger("progress", 0);
        return lvlProgress;
    }

    public void writeCompletedLevels(int levelNumber){
        if(readCompletedLevels()<levelNumber) {
            prefs.putInteger("progress", levelNumber);
            prefs.flush();
        }
    }

    @Override
    public void onObservation(IObservable o, Level.GameState arg) {
        if (arg.equals(Level.GameState.PAUSEDWIN)){
            writeCompletedLevels(((ILevel) o).getLevelNumber());
        }
    }
}
