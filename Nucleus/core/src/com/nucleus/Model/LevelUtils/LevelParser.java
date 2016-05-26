package com.nucleus.Model.LevelUtils;

import com.nucleus.Views.NAssetsData;
import com.nucleus.Utils.Assets;


// A class for reading and parsing .txt files that will be levels.
public class LevelParser {


    //private static int[] intList;   //obsolete?
    public static LevelData levelParse(int level, int width, int height) throws LevelNotExistingException {
        return splitLevelString((readFromFile(level)), width, height);
    }

    // method to read from a file and return a single String.
    private static String readFromFile(int level) throws LevelNotExistingException {
        String levelString = "";
        try {
        levelString = Assets.getFile(NAssetsData.getLevelLevel(level)).toString();
        } catch (Exception e) {
        throw new LevelNotExistingException("level does not exist");
        }
        return levelString;
    }



    //split a string where there is a new line
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