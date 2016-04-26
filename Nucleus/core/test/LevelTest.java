import com.nucleus.IGluonPoint;
import com.nucleus.INucleon;
import com.nucleus.INucleonGun;
import com.nucleus.Level;
import com.nucleus.Molecule;
import com.nucleus.NucleonGun;
import mocks.MockGluon;
import mocks.MockNucleon;
import mocks.MockNucleonGun;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

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
        gluons[0] = new MockGluon(1,1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(1, 1, gun, molecule);
        assertTrue(level.getAirborneNucleons().size() == 0);
        level.addAirborneNucleon(new MockNucleon());
        assertTrue(level.getAirborneNucleons() != null);
    }

    @Test
    public void testGetNucleonsWhenEmpty(){
        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(1,1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(1, 1, gun, molecule);
        assertTrue(level.getAirborneNucleons().size() == 0);
    }

    @Test
    public void testOutOfBounds(){
        IGluonPoint[] gluons = new MockGluon[1];
        gluons[0] = new MockGluon(1,1,1,1);
        Molecule molecule = new Molecule(gluons);

        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleon nucleon = new MockNucleon(11,11,0,0);
        nucleons.add(nucleon);
        INucleonGun gun = new MockNucleonGun(nucleons);

        Level level = new Level(10, 10, gun, molecule);
        level.addAirborneNucleon(level.getNucleonGun().shoot());
        level.outOfBoundsCheck();
        assertTrue(level.getAirborneNucleons().size()==0);
    }


}
