import com.nucleus.GluonPoint;
import com.nucleus.IMolecule;
import com.nucleus.IGluonPoint;

import org.junit.Test;

import mocks.MockGluonForMoleculeTest;
import mocks.MockMolecule;
import com.nucleus.Molecule;
import com.nucleus.Vector;

import static  org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by mirandabannsgard on 16-05-04.
 */
public class MoleculeTest {

    IGluonPoint gluon1 = new MockGluonForMoleculeTest(new Vector(1,1),1,1);//should not collide
    IGluonPoint gluon2 = new MockGluonForMoleculeTest(new Vector(2,2),1,1);//should not collide
    IGluonPoint gluon3 = new MockGluonForMoleculeTest(new Vector(3,3),1,1);//should not collide

    IGluonPoint[] gluons = {gluon1,gluon2,gluon3};

    //molecule with three different gluonpoints.
    IMolecule molecule = new Molecule(gluons);

    @Test
    public void testOfMoleculeGetRotation(){
        //rotation is set to 0
        //This should be true then
        assertTrue(molecule.getRotation() == 0);
    }

    @Test
    public void testOfMoleculeSetRotation(){
        molecule.setRotation(2);
        //rotation is no set to 2.
        //then this should be true
        assertTrue(molecule.getRotation() == 2);
    }


    @Test
    public void testOfMoleculeIsFull(){


        //since mockgluons are hard coded to isFull() = true,
        //molecule will also be full

        //Got a molecule with 3 different points.
        //The molecule won't be full until all those are full..


        assertFalse(gluon1.isFull());
        assertFalse(gluon2.isFull());
        assertFalse(gluon3.isFull());

        assertFalse(gluon1.isFull());
        gluon1.addProton();
        gluon1.addNeutron();
        assertTrue(gluon1.isFull());

        //Now the gluonPoint 1 is full.
        //But molecule is not, yet.
        assertFalse(molecule.isFull());

        assertFalse(gluon2.isFull());
        gluon2.addProton();
        gluon2.addNeutron();
        assertTrue(gluon2.isFull());

        //Now the gluonPoints 1 and 2 are full.
        //But molecule is not, yet.
        assertFalse(molecule.isFull());

        assertFalse(gluon3.isFull());
        gluon3.addProton();
        gluon3.addNeutron();
        assertTrue(gluon3.isFull());

        //Now the gluonPoints 1, 2  and 3 are full.
        //And so should the molecule
        assertTrue(molecule.isFull());

        

    }
}
