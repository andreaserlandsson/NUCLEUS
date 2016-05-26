package Model;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Molecule;
import com.nucleus.Model.Collisions.Vector;
import mocks.MockGluon;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class GluonPointRotationTest {

    Vector v = new Vector(1,1);
    IGluonPoint gluonPoint = new MockGluon(v,1,1);
    IGluonPoint[] gluonPoints = new IGluonPoint[]{gluonPoint};

    //a molecule consisting of one gluonpoint
    IMolecule molecule = new Molecule(0,0,gluonPoints);

    Vector centre = new Vector(0,0);
    Vector gluonPos = new Vector(0,0);
    //Tests for rotation of a gluonPoint. First, ordinary tests to see that the method works.

    //Test for rotation 90 degrees right, and that the method correctly returns the new values.
    @Test
    public void rotate90DegreesRight(){
        gluonPos.setCoordinates(1,0);
        double rotation = -90.0;
        //gluon rotates around (0,0), from pos (1,0) down to (0,-1)
        molecule.rotateGluon(gluonPoint, centre, gluonPos, rotation);
        Vector result = new Vector(0,1);
        assertTrue(gluonPoint.getPosition().getX() - result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getY() - result.getY() < 0.001);
    }


    //Test to do same rotation, but this time left.
    @Test
    public void rotate90DegreesLeft(){
        gluonPos.setCoordinates(1,1);
        double rotation = 90.0;
        //gluonpoint rotates around (0,0) from pos(1,1), with 90 degrees, to pos (-1,1)
        molecule.rotateGluon(gluonPoint, centre, gluonPoint.getPosition(),rotation);
        Vector result = new Vector(-1,1);
        assertTrue(gluonPoint.getPosition().getX() - result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getY() - result.getY() < 0.001);
    }


    //Test to rotate back and forth, to see that no values are lost.
    @Test
    public void rotate90DegreesLeftThenRight(){
        gluonPos.setCoordinates(1,1);
        double leftRotation = 90.0;
        double rightRotation = -90;
        molecule.rotateGluon(gluonPoint,centre,gluonPoint.getPosition(),leftRotation);
        molecule.rotateGluon(gluonPoint,centre,gluonPoint.getPosition(),rightRotation);
        Vector result = new Vector(1,1);
        assertTrue(gluonPoint.getPosition().getX() - result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getX() - result.getX() < 0.001);
    }

    @Test
    public void rotate90DegreesRightThenLeft(){

        gluonPos.setCoordinates(1,1);
        double rotation = -90;
        molecule.rotateGluon(gluonPoint, centre, gluonPoint.getPosition(),rotation);
        molecule.rotateGluon(gluonPoint, centre, gluonPoint.getPosition(),-rotation);
        Vector result = new Vector(1,1);
        assertTrue(gluonPoint.getPosition().getX() - result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getY() - result.getX() < 0.001);

    }

    //Hardcoded values with small error marginal for calculating the new position,
    //as we no longer have fixed values of 1's and 0's.
    @Test
    public void negativeValuesAndRotationTest(){
        gluonPos.setCoordinates(-1,-1);
        double rotation = 45.0;
        molecule.rotateGluon(gluonPoint,centre,gluonPoint.getPosition(),rotation);
        Vector result = new Vector(1.11E-16f,1.414f);
        assertTrue(gluonPoint.getPosition().getX()-result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getY()-result.getY() < 0.001);
    }


    //Test for the most common rotation we will make, which is 1 degree.
    @Test
    public void oneDegreeRotation (){
        gluonPos.setCoordinates(1,1);
        double rotation = 1;
        molecule.rotateGluon(gluonPoint,centre,gluonPos,rotation);
        Vector result = new Vector(0.9823f,1.017f);
        assertTrue(gluonPoint.getPosition().getX()-result.getX() < 0.001);
        assertTrue(gluonPoint.getPosition().getY()-result.getY() < 0.001);
    }

}
