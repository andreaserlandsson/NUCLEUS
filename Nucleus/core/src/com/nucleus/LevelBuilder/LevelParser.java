package com.nucleus.LevelBuilder;

import com.nucleus.AssetHandler.Assets;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.Model.LevelNotExistingException;


// A class for strings from level.txt files.
// Returns a levelData object, filled with the necessary specifics for the level.
public class LevelParser {

    public static LevelData levelParse(int level, int width, int height) throws LevelNotExistingException {
        return splitLevelString((readFromFile(level)), width, height);
    }

    // Gets the file from the assetManager, and returns it as a single string.
    private static String readFromFile(int level) throws LevelNotExistingException {
        String levelString = "";
        try {
        levelString = Assets.getFile(NAssetsData.getLevelLevel(level)).toString();
        } catch (Exception e) {
        throw new LevelNotExistingException("level does not exist");
        }
        return levelString;
    }

    // Splits the string, puts it into an int Array and returns it as a levelData object.
    private static LevelData splitLevelString (String str, int width, int height) {
        String temp = str.replaceAll(" ", "\n");
        String[] strings = temp.split("\n");
        int[] levelField = new int[strings.length];
        for (int i = 0; i < levelField.length; i++)
        {
            levelField[i] = Integer.parseInt(strings[i]);
        }
        return new LevelData(levelField, width, height);
    }
}