package com.nucleus.LevelBuilder;

import com.nucleus.AssetHandler.Assets;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.Model.LevelNotExistingException;




public class LevelParser {
    /**
     * Parses the given level and returns the specific LevelData object.
     * @param level the specific level.
     * @param width The width of the game.
     * @param height the height of the game.
     * @return
     * @throws LevelNotExistingException Should possible be higher up. Throws when file doesn't exist.
     */
    public static LevelData levelParse(int level, int width, int height) throws LevelNotExistingException {
        return splitLevelString((readFromFile(level)), width, height);
    }

    private static String readFromFile(int level) throws LevelNotExistingException {
        String levelString = "";
        try {
        levelString = Assets.getFile(NAssetsData.getLevelLevel(level)).toString();
        } catch (Exception e) {
        throw new LevelNotExistingException("level does not exist");
        }
        return levelString;
    }

    /**
     * Splits the specific levelString and puts the data into an in array.
     * @param str Level to be parsed.
     * @param width The width of the game.
     * @param height the height of the game.
     * @return The levelData object.
     */
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