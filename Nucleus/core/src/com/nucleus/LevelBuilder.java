package com.nucleus;


public class LevelBuilder{

    public void buildLevel() {
        int[] levelSpecs = LevelParser.levelParse();
        int levelNo = levelSpecs[0];
        int noOfGluonPoints = levelSpecs[1];
        int moleculeFilename = levelSpecs[2];
        int noOfProtons = levelSpecs[3];
        int noOfNeutrons = levelSpecs[4];
        int difficultyMultiplier = levelSpecs[5];

        GluonPoint[] gluonPoints = new GluonPoint[noOfGluonPoints];

        int j = 0;
        for (int i = 6; i < levelSpecs.length; i = i+4) {
            gluonPoints[j] = new GluonPoint(levelSpecs[i], levelSpecs[i + 1], levelSpecs[i + 2], levelSpecs[i + 3]);
            j++;
        }
        Molecule molecule = new Molecule(gluonPoints);

    }
}