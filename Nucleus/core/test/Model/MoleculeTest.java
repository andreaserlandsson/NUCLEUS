package Model;

import org.junit.Assert;
import org.junit.Test;


import mocks.MockGluon;

import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Vector;

import com.nucleus.Model.Molecule;
import com.nucleus.Model.IGluonPoint;


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

    IGluonPoint gluon1 = new MockGluon(v1,1,1);
    IGluonPoint gluon2 = new MockGluon(v2,1,1);
    IGluonPoint gluon3 = new MockGluon(v3,1,1);

    IGluonPoint[] gluons = {gluon1,gluon2,gluon3};


    //molecule with three different gluonpoints.


    IMolecule molecule = new Molecule(0,0,gluons);

    @Test
    public void testOfMoleculeGetRotation(){

        IMolecule molecule1 = new Molecule(0,0,gluons);

        //initial rotation is set to 0
        assertTrue(molecule1.getRotation() == 0);
        molecule1.setRotation(20);
        assertFalse(molecule1.getRotation() == 0);
        assertTrue(molecule1.getRotation()==20.0);
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

        IMolecule molecule2 = new Molecule(0,0,gluons);
        molecule2.setRotation(100);
        assertFalse(molecule2.getRotation() == 10);
        assertTrue(molecule2.getRotation() == 100);
    }


    @Test
    public void testOfMoleculeRotate(){
        Vector center = new Vector(100,100);
        Vector position = new Vector(200,100);
        Double angle = 90.0;

        //new position should be (100, 200) with rotation 90 degrees
        Vector vector222 = molecule.rotate(center,position,angle);

        assertFalse(vector222.getX() == 200.0);
        assertFalse(vector222.getY() == 100.0);
        assertTrue(vector222.getX() == 100.0);
        assertTrue(vector222.getY() == 200.0);

        //new position should be (100, 0) with rotation -90 degrees
        Vector vector333 = molecule.rotate(center,position,-90);
        assertTrue(vector333.getX() == 100.0);
        assertTrue(vector333.getY() == 0.0);
        assertFalse(vector333.getX() == 200.0);
        assertFalse(vector333.getY() == 100.0);
    }
}
