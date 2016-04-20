import com.nucleus.GluonPoint;
import com.nucleus.Level;
import com.nucleus.Molecule;
import com.nucleus.Proton;

import org.junit.Ignore;
import org.junit.Test;

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
    public void testNucleons() {
        GluonPoint[] gluons = new GluonPoint[2];
        gluons[0] = new GluonPoint(1,1,1,1);
        gluons[1] = new GluonPoint(2,2,2,2);
        Molecule molecule = new Molecule(gluons);
        Level level = new Level(1, molecule);
        assertTrue(level.getNucleons().size() == 0);
        level.addFlyingNucleon(new Proton());
        assertTrue(level.getNucleons() != null);
    }

    @Test
    public void testOutOfBounds(){

    }

    @Test
    public void testRotation(){

    }
}
