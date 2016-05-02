package com.nucleus;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

// A class for reading and parsing .txt files that will be levels.
public class LevelParser {


    //private static int[] intList;   //obsolete?
    public static LevelData levelParse(int level) {
        return splitLevelString((readFromFile(level)));
    }

    // method to read from a file and return a single String.
    public static String readFromFile(int level) {
        String levelString = "";
        try {
            Scanner sc;
            File file = new File("level_" + Integer.toString(level) + ".txt");    //temporary as we have no way to get a file
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String lineInput = sc.nextLine();
                levelString = levelString + lineInput + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return levelString;
    }

    //split a string where there is a new line
    public static LevelData splitLevelString (String str) {
        String temp = str.replaceAll(" ", "\n");
        String[] strings = temp.split("\n");
        int[] levelField = new int[strings.length];
        for (int i = 0; i < levelField.length; i++)
        {
            levelField[i] = Integer.parseInt(strings[i]);
        }
        LevelData levelData = new LevelData(levelField);
        return levelData;
    }

}