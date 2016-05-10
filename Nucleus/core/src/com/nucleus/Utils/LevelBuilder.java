package com.nucleus.Utils;

import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder {

    // Builds level and from all data that is needed for that certain level.
    public static com.nucleus.Model.Level buildLevel(int width, int height, int levelNr) {
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

            ArrayList<com.nucleus.Model.INucleon> nucleonList = new ArrayList<com.nucleus.Model.INucleon>(levelData.noOfProtons + levelData.noOfNeutrons);
            for (int i = 0; i < levelData.noOfNeutrons; i++) {
                com.nucleus.Model.Vector pos = new com.nucleus.Model.Vector(0,0);
                com.nucleus.Model.Vector vel = new com.nucleus.Model.Vector(0,0);
                nucleonList.add(new com.nucleus.Model.Neutron(pos,vel));
            }
            for (int y = 0; y < levelData.noOfProtons; y++) {
                com.nucleus.Model.Vector pos = new com.nucleus.Model.Vector(0,0);
                com.nucleus.Model.Vector vel = new com.nucleus.Model.Vector(0,0);
                nucleonList.add(new com.nucleus.Model.Proton(pos,vel));
            }
            Collections.shuffle(nucleonList);

            com.nucleus.Model.INucleonGun nucleonGun = new com.nucleus.Model.NucleonGun(width, height, nucleonList);
            com.nucleus.Model.IMolecule molecule = new com.nucleus.Model.Molecule(levelData.gluonPoints);

            return new com.nucleus.Model.Level(width, height, nucleonGun, molecule);
        }
        return null;

    }

}