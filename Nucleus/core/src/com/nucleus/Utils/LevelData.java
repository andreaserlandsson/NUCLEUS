package com.nucleus.Utils;

import com.nucleus.Model.GluonPoint;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.Vector;

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
    public LevelData(int [] levelSpecs) {
        this.levelNo = levelSpecs[levelNumberIndex];
        this.noOfGluonPoints = levelSpecs[gluonAmountIndex];
        this.moleculeFilename = levelSpecs[moleculeNameIndex];
        this.noOfProtons = levelSpecs[protonAmountIndex];
        this.noOfNeutrons = levelSpecs[neutronAmountIndex];
        this.difficultyMultiplier = levelSpecs[difficultyMultiplierIndex];

        //Fills a list with gluonPoints with their corresponding values for
        // Cordinates and neuclons needed.

        gluonPoints = new IGluonPoint[noOfGluonPoints];
        int j = 0;

        //for loop starts with 6, as we are on the sixth index in the array where the gluonpoints starts.
        for (int i = firstGluonIndex; i < levelSpecs.length; i = i+4) {
            Vector position = new Vector(levelSpecs[i], levelSpecs[i+1]);
            int protonsNeeded = levelSpecs[i+2];
            int neutronsNeeded = levelSpecs[i+3];

            //Sets the value for the specific gluonpoint
            gluonPoints[j] = new GluonPoint(position, protonsNeeded, neutronsNeeded);
            j++;
        }

    }
  }
