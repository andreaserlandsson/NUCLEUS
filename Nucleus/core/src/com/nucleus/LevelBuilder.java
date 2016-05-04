package com.nucleus;

import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder {

    // Builds level and from all data that is needed for that certain level.
    public static Level buildLevel(int width, int height, int levelNr) {
        LevelData levelData = null;
        try {
            levelData = LevelParser.levelParse(levelNr);
        } catch (LevelNotExistingException e) {
           e.printStackTrace(); //level does not exist, throws exception.
        }
        
        // Fill a <INucleon> list with all protons and neutrons that it can pass onto the Gun.
        // Scrambles it before passing, so that there is a random order of protons/neutrons.
        if (levelData != null) {
            ArrayList<INucleon> nucleonList = new ArrayList<INucleon>(levelData.getNoOfProtons() + levelData.getNoOfProtons());
            for (int i = 0; i < levelData.getNoOfNeutrons(); i++) {
                Vector v1 = new Vector(0,0);
                Vector v2 = new Vector(0,0);
                nucleonList.add(new Neutron(v1,v2));
            }
            for (int y = 0; y < levelData.getNoOfProtons(); y++) {
                Vector v1 = new Vector(0,0);
                Vector v2 = new Vector(0,0);
                nucleonList.add(new Proton(v1,v2));
            }
            Collections.shuffle(nucleonList);

            INucleonGun nucleonGun = new NucleonGun(width, height, nucleonList);
            IMolecule molecule = new Molecule(levelData.gluonPoints);

            Level newLevel = new Level(width, height, nucleonGun, molecule);
            return newLevel;
        }
        return null;

    }

}