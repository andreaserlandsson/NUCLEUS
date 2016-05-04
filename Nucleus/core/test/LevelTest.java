import com.nucleus.IGluonPoint;
import com.nucleus.INucleon;
import com.nucleus.INucleonGun;
import com.nucleus.Level;
import com.nucleus.Molecule;
import com.nucleus.NucleonGun;
import com.nucleus.Vector;

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
        Vector v1 = new Vector(1,1);
        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(v1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new NucleonGun(1,1,nucleons);
        Level level = new Level(1, 1, gun, molecule);
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.addAirborneNucleon(new MockNucleon());
        assertTrue(level.getAirborneNucleons() != null);
    }

    @Test
    public void testGetNucleonsWhenEmpty(){
        Vector v1 = new Vector(1,1);

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(v1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new NucleonGun(1,1,nucleons);
        Level level = new Level(1, 1, gun, molecule);
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testOutOfBounds(){
        Vector v1 = new Vector(1,1);
        Vector v2 = new Vector(13,13);

        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(v1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleon nucleon = new MockNucleon(v2,0,0); //levelSize + radius
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule);
        level.addAirborneNucleon(level.getNucleonGun().shoot());
        level.outOfBoundsCheck();
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testUpdate(){
        Vector v1 = new Vector(1,1);
        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(v1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleon nucleon = new MockNucleon(v1,1,1);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule);

        level.update(1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 2);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 2);
        level.update(1);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getX() == 3);
        assertTrue(level.getAirborneNucleons().get(0).getPosition().getY() == 3);
        assertTrue(level.getAirborneNucleons().size() == 1);

    }


}
