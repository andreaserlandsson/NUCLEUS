import com.nucleus.IGluonPoint;
import com.nucleus.LevelData;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class LevelDataTest {

    //Test to get all correct values from leveldata.
    @Test
    public void levelDataIndexTest(){
        int[] mockLevel = new int[] {0,2,3,4,5,6,7,8,9,10,11,12,13,14};
        LevelData levelData = new LevelData(mockLevel);
        assertTrue(levelData.getLevelNo() == mockLevel[levelData.getLevelNumberIndex()]);
        assertTrue(levelData.getNoOfGluonPoints() == mockLevel[levelData.getGluonAmountIndex()]);
        assertTrue(levelData.getMoleculeFilename() == mockLevel[levelData.getMoleculeNameIndex()]);
        assertTrue(levelData.getNoOfProtons() == mockLevel[levelData.getProtonAmountIndex()]);
        assertTrue(levelData.getNoOfNeutrons() == mockLevel[levelData.getNeutronAmountIndex()]);
        assertTrue(levelData.getDifficultyMultiplier() == mockLevel[levelData.getDifficultyLevelIndex()]);

        assertFalse(levelData.getLevelNo() == mockLevel[levelData.getProtonAmountIndex()]);
        assertFalse(levelData.getNoOfGluonPoints() == mockLevel[levelData.getLevelNumberIndex()]);
        assertFalse(levelData.getMoleculeFilename() == mockLevel[levelData.getGluonAmountIndex()]);
        assertFalse(levelData.getNoOfProtons() == mockLevel[levelData.getNeutronAmountIndex()]);
        assertFalse(levelData.getNoOfNeutrons() == mockLevel[levelData.getDifficultyLevelIndex()]);
        assertFalse(levelData.getDifficultyMultiplier() == mockLevel[levelData.getGluonAmountIndex()]);
    }

    //Test that it sets correct positions and amount of nucleons to each gluonpoint.
    @Test
    public void oneGluonPointTest() {
        int[] mockLevel = new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        LevelData levelData = new LevelData(mockLevel);
        IGluonPoint[] mockGluons = levelData.getGluonPoints();
        assertTrue(mockGluons.length == mockLevel[levelData.getGluonAmountIndex()]);
        assertTrue(mockGluons[0].getPosition().getX() == mockLevel[levelData.getFirstGluonIndex()]);
        assertTrue(mockGluons[0].getPosition().getY() == mockLevel[levelData.getFirstGluonIndex() + 1]);
        assertTrue(mockGluons[0].getProtonsNeeded() == mockLevel[levelData.getFirstGluonIndex() + 2]);
        assertTrue(mockGluons[0].getNeutronsNeeded() == mockLevel[levelData.getFirstGluonIndex() + 3]);

        //Loop through all mockgluons to assert that they have the correct corresponding values.
        int j = 0;
        for (int i = levelData.getFirstGluonIndex(); i < mockLevel.length; i = i + 4) {
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
        LevelData levelData = new LevelData(mockLevel);
        IGluonPoint[] mockGluons = levelData.getGluonPoints();
        assertTrue(mockGluons.length == mockLevel[levelData.getGluonAmountIndex()]);
        assertTrue(mockGluons[0].getPosition().getX() == mockLevel[levelData.getFirstGluonIndex()]);
        assertTrue(mockGluons[0].getPosition().getY() == mockLevel[levelData.getFirstGluonIndex()+1]);
        assertTrue(mockGluons[0].getProtonsNeeded() == mockLevel[levelData.getFirstGluonIndex()+2]);
        assertTrue(mockGluons[0].getNeutronsNeeded() == mockLevel[levelData.getFirstGluonIndex()+3]);

        //Loop through all mockgluons to assert that they have the correct corresponding values.
        int j = 0;
        for(int i = levelData.getFirstGluonIndex(); i < mockLevel.length; i = i+4){
            assertTrue(mockGluons[j].getPosition().getX() == mockLevel[i]);
            assertTrue(mockGluons[j].getPosition().getY() == mockLevel[i+1]);
            assertTrue(mockGluons[j].getProtonsNeeded() == mockLevel[i+2]);
            assertTrue(mockGluons[j].getNeutronsNeeded() == mockLevel[i+3]);
            j++;
        }

    }

}
