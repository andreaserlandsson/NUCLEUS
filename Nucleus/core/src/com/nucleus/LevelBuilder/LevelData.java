package com.nucleus.LevelBuilder;

import com.nucleus.Model.molecule.GluonPoint;
import com.nucleus.Model.molecule.IGluonPoint;
import com.nucleus.Model.Collisions.Vector;


/**
 * Data class for a level. Parses an int-array with and delegates the values to said variables.
 */
public class LevelData {
    public IGluonPoint[] gluonPoints;
    public int levelNo;
    public int noOfGluonPoints;
    public int moleculeFilename;
    public int noOfProtons;
    public int noOfNeutrons;
    public int difficultyMultiplier;

    public final int levelNumberIndex = 0;
    public final int gluonAmountIndex = 1;
    public final int moleculeNameIndex = 2;
    public final int protonAmountIndex = 3;
    public final int neutronAmountIndex = 4;
    public final int difficultyMultiplierIndex = 5;
    public final int firstGluonIndex = 6;


    //Sets the variables for a level by parsing the int[] field from
    //LevelParser.
    //The first 6 positions of the array always are the same.

    /**
     * Sets the variables for a level by parsing the int[] field passed from LevelParser.
     * Fills a list with gluonPoints with their corresponing values for coordinates and nucleons.
     * @param levelSpecs Int array containing all information for the level.
     * @param width the width for the level, used for correctly positioning the gluonPoints.
     * @param height the height for the level, used for correctly positioning the gluonPoints.
     */
    public LevelData(int [] levelSpecs, int width, int height) {
        this.levelNo = levelSpecs[levelNumberIndex];
        this.noOfGluonPoints = levelSpecs[gluonAmountIndex];
        this.moleculeFilename = levelSpecs[moleculeNameIndex];
        this.noOfProtons = levelSpecs[protonAmountIndex];
        this.noOfNeutrons = levelSpecs[neutronAmountIndex];
        this.difficultyMultiplier = levelSpecs[difficultyMultiplierIndex];

        gluonPoints = new IGluonPoint[noOfGluonPoints];
        int j = 0;

        //for loop starts with 6, as we are on the sixth index in the array where the gluonpoints starts.
        for (int i = firstGluonIndex; i < levelSpecs.length; i = i+4) {
            Vector position = new Vector(width/2 + levelSpecs[i], height/2 + levelSpecs[i+1]);
            int protonsNeeded = levelSpecs[i+2];
            int neutronsNeeded = levelSpecs[i+3];

            //Sets the value for the specific gluonpoint
            gluonPoints[j] = new GluonPoint(position, protonsNeeded, neutronsNeeded);
            j++;
        }

    }
  }
