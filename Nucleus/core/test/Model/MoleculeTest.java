package Model;

import org.junit.Test;


import mocks.MockGluon;

import com.nucleus.Model.IMolecule;
import com.nucleus.Utils.Vector;

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
    public void testGetRotation(){

        IMolecule molecule1 = new Molecule(0,0,gluons);

        //initial rotation is set to 0

        assertTrue(molecule1.getRotation() == 0);
        molecule1.setRotation(new Vector(100,100), new Vector(65,23));
        assertFalse(molecule1.getRotation() == 0);

        float rRotation = -8.26f;
        assertTrue(molecule1.getRotation()-rRotation < 0.001);
    }

    @Test
    public void testIsFull(){
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
    public void testSetRotation(){

        IMolecule molecule2 = new Molecule(0,0,gluons);
        Vector lastTouch = new Vector(5,50);
        Vector newTouch = new Vector(105,100);

        molecule2.setRotation(lastTouch,newTouch);
        float result = -43.288f;
        assertFalse(molecule2.getRotation() == 10);
        assertTrue(molecule2.getRotation() -result < 0.001);
    }

    @Test
    public void testSetRotation2(){
        Vector center = new Vector(100,100);
        Vector position = new Vector(200,100);


        //new position should be (100, 200) with rotation 90 degrees
        molecule.setRotation(center,position);

        assertFalse(gluon1.getPosition().getX() == 200.0);
        assertFalse(gluon1.getPosition().getY() == 200.0);
        assertFalse(gluon2.getPosition().getX() == 200.0);
        assertFalse(gluon2.getPosition().getY() == 200.0);
        assertFalse(gluon3.getPosition().getX() == 200.0);
        assertFalse(gluon3.getPosition().getY() == 200.0);
        
        assertTrue(gluon1.getPosition().getX() - 126.613f < 0.001);
        assertTrue(gluon1.getPosition().getY() - 63.00f < 0.001);
        assertTrue(gluon2.getPosition().getX() - 253.226f < 0.001);
        assertTrue(gluon2.getPosition().getY() - 126f < 0.001);
        assertTrue(gluon3.getPosition().getX() - 379.8400f < 0.001);
        assertTrue(gluon3.getPosition().getY() - 189.001f < 0.001);
    }

    @Test
    public void testRotateGluon() {
        IGluonPoint gluon = new MockGluon(v1, 1, 1);
        molecule.rotateGluon(gluon, v1, v2, 2.0);

        assertFalse(gluon.getPosition().getX() != 196.44913f);
        assertFalse(gluon.getPosition().getY() != 203.42903f);

        assertTrue(gluon.getPosition().getX() == 196.44913f);
        assertTrue(gluon.getPosition().getY() == 203.42903f);

    }

}
