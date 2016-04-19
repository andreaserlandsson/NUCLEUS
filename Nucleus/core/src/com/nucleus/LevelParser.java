package com.nucleus;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
// A class for reading and parsing .txt files that will be levels.
public class LevelParser {

    private static String levelString = ""; //temporary
    //private static int[] intList;   //obsolete?
    public static void levelParse() {
        splitLevelString(replaceCharacters(readFromFile()));
    }

    // method to read from a file and return a single String.
    public static String readFromFile() {
        try {
            Scanner sc;
            File file = new File("level_1.txt");    //temporary as we have no way to get a file
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String lineInput = sc.nextLine();
                levelString = levelString + lineInput + "\n";
            }
            sc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return levelString;
    }

    // Strings are inmutable, so need to make a copy of the string to be able to change letters.
    public static String replaceCharacters(String str) {
        String temp = "";
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                temp = temp + "\n";
            } else {
                temp = temp + str.charAt(i);
            }
        }
        return temp;
    }
    //split a string where there is a new line
    public static void splitLevelString (String str) {
        String[] strings = str.split("\n");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(Arrays.toString(numbers));
    }
}