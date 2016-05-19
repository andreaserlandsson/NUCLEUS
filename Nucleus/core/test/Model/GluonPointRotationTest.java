package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Molecule;
import com.nucleus.Model.Vector;

import org.junit.Test;

import mocks.MockGluon;

import static org.junit.Assert.assertTrue;

public class GluonPointRotationTest {


    //Variables that are used for all tests.
    IGluonPoint[] gluonPoints = new MockGluon[1];
    IMolecule m = new Molecule(0,0,gluonPoints);
    Vector centre = new Vector(0,0);
    Vector gluonPos = new Vector(0,0);
    //Tests for rotation of a gluonPoint. First, ordinary tests to see that the method works.

    //Test for rotation 90 degrees right, and that the method correctly returns the new values.
    @Test
    public void rotate90DegreesRight(){
        gluonPoints[0].getPosition().setCoordinates(1,0);
        double angle = -90.0;
        m.rotateGluon(gluonPoints[0], new Vector(0, 1), new Vector(1, 0), angle);
        Vector result = new Vector(0,1);
        assertTrue(gluonPoints[0].getPosition().getX() == result.getX());
        assertTrue(gluonPoints[0].getPosition().getY() == result.getY());
    }

    //Test to do same rotation, but this time left.
    @Test
    public void rotate90DegreesLeft(){
        gluonPos.setCoordinates(1,1);
        double angle = 90.0;
        Vector rotatedPosition = m.rotate(centre,gluonPos,angle);
        Vector result = new Vector(-1,1);
        assertTrue(rotatedPosition.getX() == result.getX());
        assertTrue(rotatedPosition.getY() == result.getY());
    }

    //Test to rotate back and forth, to see that no values are lost.
    @Test
    public void rotate90DegreesLeftThenRight(){
        gluonPos.setCoordinates(1,1);
        double leftRotation = 90.0;
        double rightRotation = -90;
        Vector leftRotated = m.rotate(centre,gluonPos,leftRotation);
        Vector rightRotated = m.rotate(centre,leftRotated,rightRotation);
        Vector result = new Vector(1,1);
        assertTrue(rightRotated.getX() == result.getX());
        assertTrue(rightRotated.getY() == result.getY());
    }

    //Hardcoded values with small erorr marginal for calculating the new position,
    //as we no longer have fixed values of 1's and 0's.
    @Test
    public void negativeValuesAndRotationTest(){
        gluonPos.setCoordinates(-1,-1);
        double rotation = 45.0;
        Vector rotated = m.rotate(centre,gluonPos,rotation);
        Vector result = new Vector(-1.11E-16f,-1.414f);
        assertTrue(Math.abs(rotated.getX()-result.getX()) < 0.001);
        assertTrue(Math.abs(rotated.getY()-result.getY()) < 0.001);
    }

    //Test for the most common rotation we will make, which is 1 degree.
    @Test
    public void oneDegreeRotation (){
        gluonPos.setCoordinates(1,1);
        double rotation = 1;
        Vector rotated = m.rotate(centre,gluonPos,rotation);
        Vector result = new Vector(0.9823f,1.017f);
        assertTrue(Math.abs(rotated.getX()-result.getX()) < 0.001);
        assertTrue(Math.abs(rotated.getY()-result.getY()) < 0.001);
    }
}
