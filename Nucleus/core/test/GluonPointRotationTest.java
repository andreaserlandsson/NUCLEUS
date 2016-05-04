import com.nucleus.GluonPointRotation;
import com.nucleus.Vector;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class GluonPointRotationTest {

    @Test
    public void rotate90DegreesRight(){
        Vector centre = new Vector(0,0);
        Vector gluonPos = new Vector(1,1);
        double angle = 90.0;
        GluonPointRotation gp = new GluonPointRotation();
        Vector rotatedPosition = gp.rotateGluon(centre,gluonPos,angle);
        Vector result = new Vector(1,-1);
        assertTrue(rotatedPosition.getX() == result.getX());
        assertTrue(rotatedPosition.getY() == result.getY());
    }

    @Test
    public void rotate90DegreesLeft(){
        Vector centre = new Vector(0,0);
        Vector gluonPos = new Vector(1,1);
        double angle = -90.0;
        GluonPointRotation gp = new GluonPointRotation();
        Vector rotatedPosition = gp.rotateGluon(centre,gluonPos,angle);
        Vector result = new Vector(-1,1);
        assertTrue(rotatedPosition.getX() == result.getX());
        assertTrue(rotatedPosition.getY() == result.getY());
    }

    @Test
    public void rotate90DegreesLeftThenRight(){
        Vector centre = new Vector(0,0);
        Vector gluonPos = new Vector(1,1);
        double leftRotation = -90.0;
        double rightRotation = 90;
        GluonPointRotation gp = new GluonPointRotation();
        Vector leftRotated = gp.rotateGluon(centre,gluonPos,leftRotation);
        Vector rightRotated = gp.rotateGluon(centre,leftRotated,rightRotation);
        Vector result = new Vector(1,1);
        assertTrue(rightRotated.getX() == result.getX());
        assertTrue(rightRotated.getY() == result.getY());
    }
}
