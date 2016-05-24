package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Molecule;
import com.nucleus.Utils.Vector;

import org.junit.Test;

import mocks.MockGluon;

import static org.junit.Assert.assertTrue;

public class GluonPointRotationTest {

    Vector v = new Vector(1,1);
    MockGluon g1 = new MockGluon(v,1,1);
    IGluonPoint[] gluonPoints = {g1};

    //a molecule consisting of one gluonpoint
    IMolecule m = new Molecule(0,0,gluonPoints);

    Vector centre = new Vector(0,0);
    Vector gluonPos = new Vector(0,0);
    //Tests for rotation of a gluonPoint. First, ordinary tests to see that the method works.

    //Test for rotation 90 degrees right, and that the method correctly returns the new values.
    @Test
    public void rotate90DegreesRight(){
        gluonPoints[0].getPosition().setCoordinates(1,0);
        double angle = -90.0;
        //gluon rotates around (0,0), from pos (1,0) down to (0,-1)
        m.rotateGluon(gluonPoints[0], centre, gluonPoints[0].getPosition(), angle);

        //here the x-coordinate of new position is close to 0, but exact?
        //assertTrue(gluonPoints[0].getPosition().getX() == 0);
        assertTrue(gluonPoints[0].getPosition().getY() == -1);
    }


    //Test to do same rotation, but this time left.
    @Test
    public void rotate90DegreesLeft(){
        gluonPos.setCoordinates(1,1);
        double angle = 90.0;
        //gluonpoint rotates around (0,0) from pos(1,1), with 90 degrees, to pos (-1,1)
        m.rotateGluon(gluonPoints[0], centre,gluonPoints[0].getPosition(),angle);

        Vector result = new Vector(-1,1);
        assertTrue(gluonPoints[0].getPosition().getX() == result.getX());
        assertTrue(gluonPoints[0].getPosition().getY() == result.getY());
    }


    //Test to rotate back and forth, to see that no values are lost.
    @Test
    public void rotate90DegreesLeftThenRight(){
        gluonPos.setCoordinates(1,1);
        double leftRotation = 90.0;
        double rightRotation = -90;
        m.rotateGluon(gluonPoints[0],centre,gluonPoints[0].getPosition(),leftRotation);
        m.rotateGluon(gluonPoints[0],centre,gluonPoints[0].getPosition(),rightRotation);
        Vector result = new Vector(1,1);
        assertTrue(gluonPoints[0].getPosition().getX() == result.getX());
        assertTrue(gluonPoints[0].getPosition().getX() == result.getY());
    }


    //Hardcoded values with small error marginal for calculating the new position,
    //as we no longer have fixed values of 1's and 0's.
    @Test
    public void negativeValuesAndRotationTest(){
        gluonPos.setCoordinates(-1,-1);
        double rotation = 45.0;
        m.rotateGluon(gluonPoints[0],centre,gluonPoints[0].getPosition(),rotation);
        Vector result = new Vector(1.11E-16f,1.414f);
        assertTrue(Math.abs(gluonPoints[0].getPosition().getX()-result.getX()) < 0.001);
        assertTrue(Math.abs(gluonPoints[0].getPosition().getY()-result.getY()) < 0.001);
    }


    //Test for the most common rotation we will make, which is 1 degree.
    @Test
    public void oneDegreeRotation (){
        gluonPos.setCoordinates(1,1);
        double rotation = 1;
        m.rotateGluon(gluonPoints[0],centre,gluonPoints[0].getPosition(),rotation);
        Vector result = new Vector(0.9823f,1.017f);
        assertTrue(Math.abs(gluonPoints[0].getPosition().getX()-result.getX()) < 0.001);
        assertTrue(Math.abs(gluonPoints[0].getPosition().getY()-result.getY()) < 0.001);
    }

}
