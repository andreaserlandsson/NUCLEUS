package com.nucleus.levelBuilder;

import com.nucleus.model.level.ObservableHelper;
import com.nucleus.model.molecule.IMolecule;
import com.nucleus.model.particles.INucleon;
import com.nucleus.model.level.INucleonGun;
import com.nucleus.model.level.Level;
import com.nucleus.model.LevelNotExistingException;
import com.nucleus.model.molecule.Molecule;
import com.nucleus.model.particles.Neutron;
import com.nucleus.model.level.NucleonGun;
import com.nucleus.model.particles.Proton;
import com.nucleus.model.collision.Vector;

import java.util.ArrayList;
import java.util.Collections;

public class LevelBuilder {


    /**
     * Builds level and from all data that is needed for that certain level.
     * Catches the exception thrown in LevelParser when a level does not exist.
     * Should possible be caught higher up, alternatively removed.
     * @param levelNr The specific level to be built.
     * @param width The width of the game.
     * @param height The height of the game.
     * @return Returns a levelData object for the specific level.
     */
    public static Level buildLevel(int levelNr, int width, int height) {
        LevelData levelData = null;
        try {
            levelData = com.nucleus.levelBuilder.LevelParser.levelParse(levelNr, width, height);
        } catch (LevelNotExistingException e) {
           e.printStackTrace();
        }

        /**
         * Fill a <INucleon> list with all protons and neutrons that it can pass onto the Gun.
         * Scrambles it before passing, so that there is a random order of protons/neutrons.
         * If levelData is null, it returns null, as there is no information to be found in the LevelData.
         */
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

            INucleonGun nucleonGun = new NucleonGun(width, height, nucleonList, levelData.difficultyMultiplier);
            IMolecule molecule = new Molecule(width,height, levelData.gluonPoints);
            return new Level(levelNr, width, height, nucleonGun, molecule, new ObservableHelper<Level.GameState>());
        }
        return null;

    }

}