package com.nucleus;

import java.awt.Point;

public class LevelData {
    IGluonPoint[] gluonPoints;
    int levelNo;
    int noOfGluonPoints;
    int moleculeFilename;
    int noOfProtons;
    int noOfNeutrons;
    int difficultyMultiplier;

    final int levelNumber = 0;
    final int gluonAmount = 1;
    final int moleculeName = 2;
    final int protonAmount = 3;
    final int neutronAmount = 4;
    final int difficultyLevel = 5;
    final int firstGluon = 6;

    //Sets the variables for a level by parsing the int[] field from
    //LevelParser.
    //The first 6 positions of the array always are the same.
    public LevelData(int [] levelSpecifications) {
        this.levelNo = levelSpecifications[levelNumber];
        this.noOfGluonPoints = levelSpecifications[gluonAmount];
        this.moleculeFilename = levelSpecifications[moleculeName];
        this.noOfProtons = levelSpecifications[protonAmount];
        this.noOfNeutrons = levelSpecifications[neutronAmount];
        this.difficultyMultiplier = levelSpecifications[difficultyLevel];

        //Fills a list with gluonPoints with their corresponding values for
        // Cordinates and neuclons needed.
        gluonPoints = new IGluonPoint[noOfGluonPoints];
        int j = 0;
        //for loop starts with 6, as we are on the sixth index in the array where the gluonpoints starts.
        for (int i = firstGluon; i < levelSpecifications.length; i = i+4) {
            Vector position = new Vector(levelSpecifications[i], levelSpecifications[i+1]);

            int protonsNeeded = levelSpecifications[i+2];
            int neutronsNeeded = levelSpecifications[i+3];
            gluonPoints[j] = new GluonPoint(position, protonsNeeded, neutronsNeeded);
            j++;
        }


    }

}
