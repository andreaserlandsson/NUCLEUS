package com.nucleus.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker implements IProgressTracker, Observer{
    private static Preferences prefs;
    private Observable level;

    public ProgressTracker(Observable level){
        prefs = Gdx.app.getPreferences("prefs");
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
        }
    }

    public boolean checkLevelPermission(int levelNumber){
        if(levelNumber<=readCompletedLevels()+1)
            return true;
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("won")){
            Gdx.app.log("Tjena", "Morsan");
            Gdx.app.log("ASDASDASD","ASDASDÖKASJDÖASDJÖASLDKÖASLDKAÖSDKAÖSDLKAÖSLDKAÖSLDKAÖSDLK");
            //writeCompletedLevels((ILevel)level.getLevelNumber());
        }
    }
}
