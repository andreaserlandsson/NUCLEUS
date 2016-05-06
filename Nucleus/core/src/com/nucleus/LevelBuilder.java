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
           e.printStackTrace(); //level does not exist, catches exception.
                                //Should possibly be higher up.
        }
        
        // Fill a <INucleon> list with all protons and neutrons that it can pass onto the Gun.
        // Scrambles it before passing, so that there is a random order of protons/neutrons.
        if (levelData != null) {

            ArrayList<INucleon> nucleonList = new ArrayList<INucleon>(levelData.noOfProtons + levelData.noOfNeutrons);
            for (int i = 0; i < levelData.noOfNeutrons; i++) {
                Vector pos = new Vector(0,0);
                Vector vel = new Vector(0,0);
                nucleonList.add(new Neutron(pos,vel));
            }
            for (int y = 0; y < levelData.noOfProtons; y++) {
                Vector pos = new Vector(0,0);
                Vector vel = new Vector(0,0);
                nucleonList.add(new Proton(pos,vel));
            }
            Collections.shuffle(nucleonList);

            INucleonGun nucleonGun = new NucleonGun(width, height, nucleonList);
            IMolecule molecule = new Molecule(levelData.gluonPoints);

            return new Level(width, height, nucleonGun, molecule);
        }
        return null;

    }

}