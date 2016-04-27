package com.nucleus;


import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder {

    // Reads levelfile and gets all information that is needed for that certain level.
    public static Level buildLevel(int width, int height, int levelNr) {
        int[] levelSpecs = LevelParser.levelParse(levelNr);
        int levelNo = levelSpecs[0]; //obsolete?
        int noOfGluonPoints = levelSpecs[1];
        int moleculeFilename = levelSpecs[2];
        int noOfProtons = levelSpecs[3];
        int noOfNeutrons = levelSpecs[4];
        int difficultyMultiplier = levelSpecs[5];

        IGluonPoint[] gluonPoints = new GluonPoint[noOfGluonPoints];

        //Loop to assign each gluon point the values it needs for each level.
        int j = 0;
        for (int i = 6; i < levelSpecs.length; i = i+4) {
            gluonPoints[j] = new GluonPoint(levelSpecs[i], levelSpecs[i + 1], levelSpecs[i + 2], levelSpecs[i + 3]);
            j++;
        }

        // Fill a <INucleon> list with all protons and neutrons that it can pass onto the Gun.
        // Scrambles it before passing, so that there is a random order of protons/neutrons.
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>(noOfProtons+noOfNeutrons);
        for(int i = 0; i < noOfNeutrons; i++) {
            nucleonList.add(new Neutron(0,0,0,0));
        }

        for (int y = 0; y < noOfProtons; y++) {
            nucleonList.add(new Proton(0, 0, 0, 0));
        }
        Collections.shuffle(nucleonList);


        INucleonGun nucleonGun = new NucleonGun(width, height, nucleonList);
        IMolecule molecule = new Molecule(gluonPoints);

        Level newLevel = new Level(width, height, nucleonGun, molecule);

        return  newLevel;

    }

}