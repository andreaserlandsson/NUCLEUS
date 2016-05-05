import com.nucleus.GluonPoint;
import com.nucleus.IMolecule;
import com.nucleus.IGluonPoint;

import org.junit.Test;

import mocks.MockGluon;
import mocks.MockMolecule;
import com.nucleus.Molecule;
import com.nucleus.Vector;

import static  org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by mirandabannsgard on 16-05-04.
 */
public class MoleculeTest {


    Vector v1 = new Vector(1,1);
    Vector v2 = new Vector(2,2);
    Vector v3 = new Vector(3,3);

    IGluonPoint gluon1 = new MockGluon(v1,1,1);//should not collide
    IGluonPoint gluon2 = new MockGluon(v2,1,1);//should not collide
    IGluonPoint gluon3 = new MockGluon(v3,1,1);//should not collide

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

        //TODO, when got answers, test molecule not full

        //since mockgluons are hard coded to isFull() = true,
        //molecule will also be full


        assertTrue(molecule.isFull());

        

    }
}
