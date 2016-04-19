import com.nucleus.Molecule;
import com.nucleus.Neutron;
import com.nucleus.Nucleon;
import com.nucleus.Proton;
import com.nucleus.Level;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        int lvl = 1;
        List<Nucleon> nucleons = new ArrayList<Nucleon>();
        nucleons.add(new Proton());
        nucleons.add(new Proton());
        nucleons.add(new Neutron());
        nucleons.add(new Neutron());
        Molecule molecule = new Molecule();
        Level level = new Level(lvl, nucleons, molecule);
        assertTrue(level.getNucleons()==nucleons);
    }

    @Test
    public void testGetMolecule() {
        int lvl = 1;
        List<Nucleon> nucleons = new ArrayList<Nucleon>();
        nucleons.add(new Proton());
        Molecule molecule = new Molecule();
        Level level = new Level(lvl, nucleons, molecule);
        assertTrue(level.getMolecule()==molecule);
    }

    @Test
    public void testOutOfBounds(){

    }


    @Test
    public void testRotation(){

    }


}
