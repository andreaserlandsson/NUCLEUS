package Model;

import org.junit.Test;


import mocks.MockGluon;

import com.nucleus.Model.Vector;


import static  org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by mirandabannsgard on 16-05-04.
 */
public class MoleculeTest {

    Vector v1 = new Vector(1,1);
    Vector v2 = new Vector(2,2);
    Vector v3 = new Vector(3,3);


    com.nucleus.Model.IGluonPoint gluon1 = new MockGluon(v1,1,1);
    com.nucleus.Model.IGluonPoint gluon2 = new MockGluon(v2,1,1);
    com.nucleus.Model.IGluonPoint gluon3 = new MockGluon(v3,1,1);




    com.nucleus.Model.IGluonPoint[] gluons = {gluon1,gluon2,gluon3};

    //molecule with three different gluonpoints.
    com.nucleus.Model.IMolecule molecule = new com.nucleus.Model.Molecule(gluons);


    @Test
    public void testOfMoleculeSetRotation(){
        //TODO
    }


    @Test
    public void testOfMoleculeGetRotation(){
        //rotation is set to 0
        //This should be true then
        assertTrue(molecule.getRotation() == 0);
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

    @Test
    public void testOfMoleculeRotate(){
        //TODO
    }
}
