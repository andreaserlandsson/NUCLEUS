package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.nucleus.Model.level.ILevel;
import com.nucleus.Model.nucleusObservers.IObservable;
import com.nucleus.Model.nucleusObservers.IObserver;
import com.nucleus.Model.level.Level;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker implements IObserver<Level.GameState> {
    private static Preferences prefs = Gdx.app.getPreferences("prefs");
    private IObservable level;

    public ProgressTracker(IObservable level){
        this.level = level;
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
