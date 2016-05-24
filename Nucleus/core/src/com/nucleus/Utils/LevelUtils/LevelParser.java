package com.nucleus.Utils.LevelUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.nucleus.Utils.*;

// A class for reading and parsing .txt files that will be levels.
public class LevelParser {


    //private static int[] intList;   //obsolete?
    public static LevelData levelParse(int level, int width, int height) throws LevelNotExistingException {
        return splitLevelString((readFromFile(level)), width, height);
    }

    // method to read from a file and return a single String.
    private static String readFromFile(int level) throws LevelNotExistingException {
        String levelString = "";

        FileHandle file = Gdx.files.internal("levels/level_" + Integer.toString(level) + ".txt");
        levelString = file.readString();
        /*try {
            Scanner sc;
            File file = libs();
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String lineInput = sc.nextLine();
                levelString = levelString + lineInput + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
        throw new LevelNotExistingException("level does not exist");
        } */
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
        return new LevelData(levelField, width, height, new ProgressTracker());
    }

}