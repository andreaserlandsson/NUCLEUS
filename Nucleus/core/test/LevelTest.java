import com.nucleus.IGluonPoint;
import com.nucleus.INucleon;
import com.nucleus.INucleonGun;
import com.nucleus.Level;
import com.nucleus.Molecule;
import com.nucleus.NucleonGun;
import com.nucleus.mocks.MockGluon;

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
    public void testgetNucleons() {
        IGluonPoint[] gluons = new MockGluon[2];
        gluons[0] = new MockGluon(1,1,1,1);
        gluons[1] = new MockGluon(2,2,2,2);
        Molecule molecule = new Molecule(gluons);
        ArrayList<INucleon> nucleons = new ArrayList<INucleon>();
        INucleonGun gun = new NucleonGun(nucleons);
        Level level = new Level(1, 1, gun, molecule);
        assertTrue(level.getNucleons().size() == 0);
        level.addAirborneNucleon();
        assertTrue(level.getNucleons() != null);
    }

    @Test
    public void testOutOfBounds(){

    }

    @Test
    public void testRotation(){

    }
}
