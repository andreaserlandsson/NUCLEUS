package com.nucleus.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class LevelPermissions {
    private static Preferences prefs = Gdx.app.getPreferences("prefs");

    public static boolean checkLevelPermission(int levelNumber){
        int lvlProgress = prefs.getInteger("progress", 0);
        return levelNumber <= lvlProgress + 1;
    }
}
