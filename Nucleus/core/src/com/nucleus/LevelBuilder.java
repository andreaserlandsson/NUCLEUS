package com.nucleus;


import java.util.PriorityQueue;

public class LevelBuilder{

    public static Level buildLevel(int width, int height, int level) {
        int[] levelSpecs = LevelParser.levelParse(level);
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
        PriorityQueue<Nucleon> pq = new PriorityQueue<Nucleon>(noOfProtons+noOfNeutrons);
        for(int i = 0; i < noOfNeutrons; i++) {

        }

        NucleonGun nucleonGun = new NucleonGun();
        Molecule molecule = new Molecule(gluonPoints);
        Level newLevel = new Level(width, height, nucleonGun, molecule);
        return newLevel;
    }
}