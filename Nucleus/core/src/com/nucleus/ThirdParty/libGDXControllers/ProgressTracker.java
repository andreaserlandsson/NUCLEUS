package com.nucleus.ThirdParty.libGDXControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.nucleus.Model.IProgressTracker;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker implements IProgressTracker{
    Preferences prefs = Gdx.app.getPreferences("prefs");

    public ProgressTracker(){
    }

    public int readCompletedLevels(){
        int lvlProgress = prefs.getInteger("progress", 0);
        return lvlProgress;
    }

    public void writeCompletedLevels(int levelNumber){
        if(readCompletedLevels()<levelNumber)
            prefs.putInteger("progress", levelNumber);
    }
}
