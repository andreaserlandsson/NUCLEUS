package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.Level;
import com.nucleus.Utils.Vector;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;


import java.util.ArrayList;

import mocks.MockGluon;
import mocks.MockMolecule;
import mocks.MockNucleon;
import mocks.MockNucleonGun;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by erik on 19/04/16.
 */
public class LevelTest {
    int width = 0;
    int height = 0;
    int levelNumber = 0;
    Vector gluonPositions = new Vector(1,1);
    int pNeeded = 0;
    int nNeeded = 0;

    Vector nucleonPos = new Vector(0,0);
    Vector nucleonVel = new Vector(0,0);
    INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
    ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();

    Vector v1 = new Vector(100,100);
    Vector v2 = new Vector(200,200);
    Vector v3 = new Vector(300,300);
    IGluonPoint gluon1 = new MockGluon(v1,1,1);
    IGluonPoint gluon2 = new MockGluon(v2,1,1);
    IGluonPoint gluon3 = new MockGluon(v3,1,1);
    IGluonPoint[] gluons = {gluon1,gluon2,gluon3};

    INucleonGun gun = new MockNucleonGun(nucleonList);
    MockMolecule molecule = new MockMolecule(gluons);

    Level level = new Level(levelNumber, width, height, gun, molecule, gluons);

    @Test
    public void thisAlwaysPasses() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }

    @Test
    public void testGetLevelNumber(){

        assertTrue(level.getLevelNumber() == 0);

    }

    @Test
    public void testGetWidth(){

        assertTrue(level.getWidth() == 0);
    }

    @Test
    public void testGetHeight(){

        assertTrue(level.getHeight() == 0);

    }

    @Test
    public void testIsGameWon(){
        molecule.setFull(false);
        assertTrue(!level.isGameWon());
        molecule.setFull(true);
        level.update(1); // this also tests the CheckWinGame() method called via the update() method
        assertTrue(level.isGameWon());

    }

    @Test
    public void testIsGameLost(){

        molecule.setFull(true);
        assertTrue(!level.isGameLost());
        molecule.setFull(false);
        level.update(1); // this also tests the loseGame() method called via the update() method
        assertTrue(level.isGameLost());

    }

    @Test
    public void testIsGamePaused(){

        assertTrue(!level.isGamePaused());
        level.pause();
        assertTrue(level.isGamePaused());

    }

    @Test
    public void testSetGamePauesd(){
        level.setGamePaused();
        assertTrue(level.isGamePaused());

    }

    @Test
    public void testGetNucleonGun(){

        assertTrue(level.getNucleonGun() == this.gun);

    }

    @Test
    public void testGetAirBorneNucleons(){

        nucleonList.add(mockNucleon);
        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().add(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().remove(nucleonList.get(0)));
        assertTrue(level.getAirborneNucleons().size() == 0);

    }

    @Test
    public void testGetMolecule(){

        assertTrue(level.getMolecule() == this.molecule);

    }

    @Test
    public void testGetGluons(){

        assertTrue(level.getGluons() == this.gluons);

    }

    @Test
    public void testAddAirBorneNucleon(){

        nucleonList.add(mockNucleon);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.addAirborneNucleon(nucleonList.get(0));
        assertTrue(level.getAirborneNucleons().size() == 2);

    }

    @Test
    public void testIsOutOfBoundsCheck(){

    }

    @Test
    public void testRemoveOutOfBoundsNucleons(){

        //this also tests the removeNucleon method

    }

    @Test
    public void testPause(){

    }

    @Test
    public void testResume(){

    }

    @Test
    public void testUpdate(){

        //this also tests the checkWinGame method

        //this also  tests checkAllNucleonsStatus() which in turn tests
            //the checkWinGame method
            //the loseGame method
            //the removeNucleon method

    }

    /*
    @Test
    public void testGetNucleons() {

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.addAirborneNucleon(new MockNucleon());
        assertTrue(level.getAirborneNucleons() != null);
    }

    @Test
    public void testGetNucleonsWhenEmpty(){

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);
        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testOutOfBounds(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(13,13);
        Vector nucleonVel = new Vector(5,5);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel); //levelSize + radius
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);
        level.addAirborneNucleon(level.getNucleonGun().shoot());
        System.out.println(level.getAirborneNucleons().size());
        level.removeOutOfBoundsNucleons();

        //Shouldn't this be 0...? Wäwä
        assertTrue(level.getAirborneNucleons().size() == 1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        level.update(1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.update(6);
        level.removeOutOfBoundsNucleons();
        assertTrue(level.getAirborneNucleons().size() == 1);
        System.out.println(level.getAirborneNucleons().get(0).getPosition().getX());
        assertTrue(level.getAirborneNucleons().size() == 1);
        //still 1 and not 0...


    }

    @Test
    public void testUpdate(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(width,heigth,gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(100, 100, gun, molecule,gluons);

        level.update(1);
        assertTrue(gun.isEmpty());

        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 2.0);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 2.0);


        level.update(1);

        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().isEmpty());

        level.update(1);

        //level.getAirborneNucleons().get(0).getPosition().getX();
        //this will give IndexOutOutOfBounds?? Wääh,

    }

    @Test
    public void testGluonCollisionCheck(){
        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(10,10,gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);

        level.update(1);
        assertTrue(level.getGluons()[0].getProtonsNeeded() == 1);

        level.update(1);
        assertTrue(level.getGluons()[0].getProtonsNeeded() == 0);

    }
    */
}
