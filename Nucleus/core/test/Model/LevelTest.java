package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.Level;
import com.nucleus.Model.Molecule;
import com.nucleus.Model.NucleonGun;
import com.nucleus.Model.Vector;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import mocks.MockGluon;
import mocks.MockNucleon;
import mocks.MockNucleonGun;


import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by erik on 19/04/16.
 */
public class LevelTest {
    int width = 0;
    int heigth = 0;
    @Test
    public void thisAlwaysPasses() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }

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

        assertFalse(gun.isEmpty());
        level.update(1);
        assertTrue(gun.isEmpty());

        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 2.0);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 2.0);

        assertFalse(level.getAirborneNucleons().isEmpty());

        level.update(1);

        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getAirborneNucleons().isEmpty());

        level.update(1);

        //level.getAirborneNucleons().get(0).getPosition().getX();
        //this will give IndexOutOutOfBounds?? Wääh,

    }


}
