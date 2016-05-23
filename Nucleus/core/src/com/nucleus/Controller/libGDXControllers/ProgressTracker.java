package com.nucleus.Controller.libGDXControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.nucleus.Model.IProgressTracker;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker implements IProgressTracker{
    private Preferences prefs;

    public ProgressTracker(){
        prefs = Gdx.app.getPreferences("prefs");
    }

    private int readCompletedLevels(){
        int lvlProgress = prefs.getInteger("progress", 0);
        return lvlProgress;
    }

    public void writeCompletedLevels(int levelNumber){
        if(readCompletedLevels()<levelNumber) {
            prefs.putInteger("progress", levelNumber);
        }
    }

    public boolean checkLevelPermission(int levelNumber){
        if(levelNumber<=readCompletedLevels()-1)
            return true;
        return false;
    }
}
