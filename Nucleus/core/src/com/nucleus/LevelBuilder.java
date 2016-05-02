package com.nucleus;

import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder {

    // Builds level and from all data that is needed for that certain level.
    public static Level buildLevel(int width, int height, int levelNr) {
        LevelData levelData = LevelParser.levelParse(levelNr);

        // Fill a <INucleon> list with all protons and neutrons that it can pass onto the Gun.
        // Scrambles it before passing, so that there is a random order of protons/neutrons.

        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>(levelData.noOfProtons+levelData.noOfNeutrons);
        for(int i = 0; i < levelData.noOfNeutrons; i++) {
            nucleonList.add(new Neutron(0,0,0,0));
        }
        for (int y = 0; y < levelData.noOfProtons; y++) {
            nucleonList.add(new Proton(0, 0, 0, 0));
        }
        Collections.shuffle(nucleonList);

        INucleonGun nucleonGun = new NucleonGun(width, height, nucleonList);
        IMolecule molecule = new Molecule(levelData.gluonPoints);

        Level newLevel = new Level(width, height, nucleonGun, molecule);

        return  newLevel;

    }

}