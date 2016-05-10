package Model;

import org.junit.Test;


import mocks.MockGluon;

import com.nucleus.Model.Vector;

import com.nucleus.Model.Molecule;


import static  org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by mirandabannsgard on 16-05-04.
 */
public class MoleculeTest {

    Vector v1 = new Vector(100,100);
    Vector v2 = new Vector(200,200);
    Vector v3 = new Vector(300,300);
    //the positions for all gluons.




    com.nucleus.Model.IGluonPoint gluon1 = new MockGluon(v1,1,1);
    com.nucleus.Model.IGluonPoint gluon2 = new MockGluon(v2,1,1);
    com.nucleus.Model.IGluonPoint gluon3 = new MockGluon(v3,1,1);

    com.nucleus.Model.IGluonPoint[] gluons = {gluon1,gluon2,gluon3};


    //molecule with three different gluonpoints.
    com.nucleus.Model.IMolecule molecule = new Molecule(gluons);

    @Test
    public void testOfMoleculeGetRotation(){
        //rotation is set to 0
        //This should be true then
        assertTrue(molecule.getRotation() == 0);
        //molecule.setRotation(2);
        //System.out.println(molecule.getRotation());
        //molecule.setRotation(2);
        //assertFalse(molecule.getRotation() == 0);
        //assertTrue(molecule.getRotation() == 2.0);
    }

    @Test
    public void testOfMoleculeIsFull(){
        //Got a molecule with 3 different gluonpoints.
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

        //Now the gluonPoints 1 and 2 are full. But not 3, and
        //so, molecule is not full either, yet.
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
    public void testOfMoleculeSetRotation(){
        //TODO

        //here the new position of all the gluonpoints are decided,
        //uses the rotate-method.
            //the center of the molecule is needed
            //for each gluonpoint, a new position is calculated
            //then this new position is set

        //all gluonpoints are getting a new postion depending on the
        //angle rotated.

        System.out.println();
    }









    @Test
    public void testOfMoleculeRotate(){
        //TODO

        //Rotate the molecule
        //vector that is the center, a vector for a position, a some angle

        //angle
        Vector vector1 = new Vector(1,1);
        Vector vector2 = new Vector(2,2);
        Double d = 2.0;
        molecule.rotate(vector1,vector2,d);



    }
}
