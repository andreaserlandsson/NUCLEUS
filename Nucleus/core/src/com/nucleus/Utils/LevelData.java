package com.nucleus.Utils;

public class LevelData {
    com.nucleus.Model.IGluonPoint[] gluonPoints;
    int levelNo;
    int noOfGluonPoints;
    int moleculeFilename;
    int noOfProtons;
    int noOfNeutrons;
    int difficultyMultiplier;

    final int levelNumberIndex = 0;
    final int gluonAmountIndex = 1;
    final int moleculeNameIndex = 2;
    final int protonAmountIndex = 3;
    final int neutronAmountIndex = 4;
    final int difficultyLevelIndex = 5;
    final int firstGluonIndex = 6;

    //Sets the variables for a level by parsing the int[] field from
    //LevelParser.
    //The first 6 positions of the array always are the same.
    public LevelData(int [] levelSpecs) {
        this.levelNo = levelSpecs[levelNumberIndex];
        this.noOfGluonPoints = levelSpecs[gluonAmountIndex];
        this.moleculeFilename = levelSpecs[moleculeNameIndex];
        this.noOfProtons = levelSpecs[protonAmountIndex];
        this.noOfNeutrons = levelSpecs[neutronAmountIndex];
        this.difficultyMultiplier = levelSpecs[difficultyLevelIndex];

        //Fills a list with gluonPoints with their corresponding values for
        // Cordinates and neuclons needed.

        gluonPoints = new com.nucleus.Model.IGluonPoint[noOfGluonPoints];
        int j = 0;

        //for loop starts with 6, as we are on the sixth index in the array where the gluonpoints starts.
        for (int i = firstGluonIndex; i < levelSpecs.length; i = i+4) {
            com.nucleus.Model.Vector position = new com.nucleus.Model.Vector(levelSpecs[i], levelSpecs[i+1]);
            int protonsNeeded = levelSpecs[i+2];
            int neutronsNeeded = levelSpecs[i+3];

            //Sets the value for the specific gluonpoint
            gluonPoints[j] = new com.nucleus.Model.GluonPoint(position, protonsNeeded, neutronsNeeded);
            j++;
        }
    }

    public com.nucleus.Model.IGluonPoint[] getGluonPoints() {
        return gluonPoints;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public int getNoOfGluonPoints() {
        return noOfGluonPoints;
    }

    public int getMoleculeFilename() {
        return moleculeFilename;
    }

    public int getNoOfProtons() {
        return noOfProtons;
    }

    public int getNoOfNeutrons() {
        return noOfNeutrons;
    }

    public int getDifficultyMultiplier() {
        return difficultyMultiplier;
    }

    public int getLevelNumberIndex() {
        return levelNumberIndex;
    }

    public int getGluonAmountIndex() {
        return gluonAmountIndex;
    }

    public int getMoleculeNameIndex() {
        return moleculeNameIndex;
    }

    public int getProtonAmountIndex() {
        return protonAmountIndex;
    }

    public int getNeutronAmountIndex() {
        return neutronAmountIndex;
    }

    public int getDifficultyLevelIndex() {
        return difficultyLevelIndex;
    }

    public int getFirstGluonIndex() {
        return firstGluonIndex;
    }
}
