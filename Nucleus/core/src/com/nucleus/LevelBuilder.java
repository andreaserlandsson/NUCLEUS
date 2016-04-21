package com.nucleus;


import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder{

    public static Level buildLevel(int level) {
        int[] levelSpecs = LevelParser.levelParse(level);
        int levelNo = levelSpecs[0]; //obsolete?
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
        ArrayList<Nucleon> nucleonList = new ArrayList<Nucleon>(noOfProtons+noOfNeutrons);
        for(int i = 0; i < noOfNeutrons; i++) {
            nucleonList.add(new Neutron(0,0,0,0));
        }
        for (int y = 0; y<noOfProtons;y++) {
            nucleonList.add(new Proton(0,0,0,0));
        }
        Collections.shuffle(nucleonList);


        NucleonGun nucleonGun = new NucleonGun(nucleonList);
        Molecule molecule = new Molecule(gluonPoints);
        Level newLevel = new Level(molecule,nucleonGun);
        return newLevel;
    }


}