package LevelBuilder;

import com.nucleus.model.molecule.IGluonPoint;
import com.nucleus.levelBuilder.LevelData;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LevelDataTest {

    //Test to get all correct values from leveldata.

    @Test
    public void levelDataIndexTest(){
        int[] mockLevel = new int[] {0,2,3,4,5,6,7,8,9,10,11,12,13,14};
        LevelData levelData = new LevelData(mockLevel,1,1);
        assertTrue(levelData.levelNo == mockLevel[levelData.levelNumberIndex]);
        assertTrue(levelData.noOfGluonPoints == mockLevel[levelData.gluonAmountIndex]);
        assertTrue(levelData.moleculeFilename == mockLevel[levelData.moleculeNameIndex]);
        assertTrue(levelData.noOfProtons == mockLevel[levelData.protonAmountIndex]);
        assertTrue(levelData.noOfNeutrons == mockLevel[levelData.neutronAmountIndex]);
        assertTrue(levelData.difficultyMultiplier == mockLevel[levelData.difficultyMultiplierIndex]);
    }

    //Test that it sets correct positions and amount of nucleons to each gluonpoint.
    @Test
    public void oneGluonPointTest() {
        int[] mockLevel = new int[] {0, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        LevelData levelData = new LevelData(mockLevel,1,1);
        IGluonPoint[] mockGluons = levelData.gluonPoints;
        assertTrue(mockGluons.length == mockLevel[levelData.gluonAmountIndex]);
        assertTrue(mockGluons[0].getPosition().getX() == mockLevel[levelData.firstGluonIndex]);
        assertTrue(mockGluons[0].getPosition().getY() == mockLevel[levelData.firstGluonIndex+ 1]);
        assertTrue(mockGluons[0].getProtonsNeeded() == mockLevel[levelData.firstGluonIndex+ 2]);
        assertTrue(mockGluons[0].getNeutronsNeeded() == mockLevel[levelData.firstGluonIndex + 3]);

        //Loop through all mockgluons to assert that they have the correct corresponding values.
        int j = 0;
        for (int i = levelData.firstGluonIndex; i < mockLevel.length; i = i + 4) {
            assertTrue(mockGluons[j].getPosition().getX() == mockLevel[i]);
            assertTrue(mockGluons[j].getPosition().getY() == mockLevel[i + 1]);
            assertTrue(mockGluons[j].getProtonsNeeded() == mockLevel[i + 2]);
            assertTrue(mockGluons[j].getNeutronsNeeded() == mockLevel[i + 3]);
            j++;
        }
    }

    //Repeat test for a mockLevel with double the amount of gluonPoints.
    @Test
    public void twoGluonPointsTest(){
        int[] mockLevel = new int[] {0,2,3,4,5,6,7,8,9,10,11,12,13,14};
        LevelData levelData = new LevelData(mockLevel,1,1);
        IGluonPoint[] mockGluons = levelData.gluonPoints;
        assertTrue(mockGluons.length == mockLevel[levelData.gluonAmountIndex]);
        assertTrue(mockGluons[0].getPosition().getX() == mockLevel[levelData.firstGluonIndex]);
        assertTrue(mockGluons[0].getPosition().getY() == mockLevel[levelData.firstGluonIndex+1]);
        assertTrue(mockGluons[0].getProtonsNeeded() == mockLevel[levelData.firstGluonIndex+2]);
        assertTrue(mockGluons[0].getNeutronsNeeded() == mockLevel[levelData.firstGluonIndex+3]);

        //Loop through all mockgluons to assert that they have the correct corresponding values.
        int j = 0;
        for(int i = levelData.firstGluonIndex; i < mockLevel.length; i = i+4){
            assertTrue(mockGluons[j].getPosition().getX() == mockLevel[i]);
            assertTrue(mockGluons[j].getPosition().getY() == mockLevel[i+1]);
            assertTrue(mockGluons[j].getProtonsNeeded() == mockLevel[i+2]);
            assertTrue(mockGluons[j].getNeutronsNeeded() == mockLevel[i+3]);
            j++;
        }

    }
}
