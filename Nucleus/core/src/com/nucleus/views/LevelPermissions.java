package com.nucleus.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by erik on 24/05/16.
 */
public class LevelPermissions {
    private static Preferences prefs = Gdx.app.getPreferences("prefs");

    public static boolean checkLevelPermission(int levelNumber){
        int lvlProgress = prefs.getInteger("progress", 0);
        if(levelNumber<=lvlProgress+1)
            return true;
        return false;
    }
}
