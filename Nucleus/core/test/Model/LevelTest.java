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



import static org.junit.Assert.assertTrue;

/**
 * Created by erik on 19/04/16.
 */
public class LevelTest {
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
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new NucleonGun(1,1,nucleons);
        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.addAirborneNucleon(new MockNucleon());
        assertTrue(level.getAirborneNucleons() != null);
    }

    @Test
    public void testGetNucleonsWhenEmpty(){

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new NucleonGun(1,1,nucleons);
        Level level = new Level(1, 1, gun, molecule,gluons);
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testOutOfBounds(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(13,13);
        Vector nucleonVel = new Vector(0,0);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel); //levelSize + radius
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);
        level.addAirborneNucleon(level.getNucleonGun().shoot());
        level.outOfBoundsCheck();
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testUpdate(){

        IGluonPoint[] gluons = new MockGluon[1];

        gluons[0] = new MockGluon(new Vector(1,1),1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule,gluons);

        level.update(1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 2);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 2);
        level.update(1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 3);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 3);
        assertTrue(level.getAirborneNucleons().size() == 1);

    }

    @Test
    public void testGluonCollisionCheck(){
        Vector gluonPos = new Vector(2,2);
        Vector gluonPos2 = new Vector(3,3);
        IGluonPoint[] gluons = new MockGluon[2];
        gluons[0] = new MockGluon(gluonPos,1,0);
        gluons[0] = new MockGluon(gluonPos2,1,0);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        Vector nucleonPos = new Vector(1,1);
        Vector nucleonVel = new Vector(1,1);
        INucleon nucleon = new MockNucleon(nucleonPos,nucleonVel);
        nucleons.add(nucleon);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule);

        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        level.gluonCollisionCheck();
        assertTrue(level.getAirborneNucleons().size() == 0);
        assertTrue(level.getMolecule().getGluonPoint(0).isFull());
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.update(1);
        assertTrue(level.getAirborneNucleons().size() == 1);
        assertTrue(level.getMolecule().getGluonPoint(1).isFull());
        assertTrue(level.getAirborneNucleons().size() == 0);
    }
}
