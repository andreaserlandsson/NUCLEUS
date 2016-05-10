package Model;

import com.nucleus.Model.GluonPoint;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.Vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andreaserlandsson on 26/04/16.
 */
public class GluonPointTest {

    @Test
    public void testGluonPointFilled() {
        Vector position = new Vector(10, 10);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertTrue(gluonPoint.isFull());
        gluonPoint.addNeutron();
        gluonPoint.addProton();
        assertFalse(gluonPoint.isFull());

        IGluonPoint gluonPoint1 = new GluonPoint(position, 1, 1);
        assertFalse(gluonPoint1.isFull());
        gluonPoint1.addNeutron();
        gluonPoint1.addProton();
        assertTrue(gluonPoint1.isFull());
    }

    @Test
    public void testAddProton() {
        Vector position = new Vector(1, 1);

        //a new gluonpoint maxProtons = 2, and maxNeutrons = 0
        IGluonPoint gluonPoint = new GluonPoint(position,2,0);

        assertTrue(gluonPoint.getProtonsNeeded() == 2);
        assertFalse(gluonPoint.getProtonsNeeded() == 0);

        gluonPoint.addProton();

        assertTrue(gluonPoint.getProtonsNeeded() == 1);
        assertFalse(gluonPoint.getProtonsNeeded() == 0);

        gluonPoint.addProton();

        assertTrue(gluonPoint.getProtonsNeeded() == 0);
        assertFalse(gluonPoint.getProtonsNeeded() == 2);
    }

    @Test
    public void testAddNeutron() {
        Vector position = new Vector(1, 1);
        GluonPoint gluonPoint = new GluonPoint(position, 0, 2);

        assertTrue(gluonPoint.getNeutronsNeeded() == 2);
        assertFalse(gluonPoint.getNeutronsNeeded() == 0);

        gluonPoint.addNeutron();

        assertTrue(gluonPoint.getNeutronsNeeded() == 1);
        assertFalse(gluonPoint.getNeutronsNeeded() == 0);

        gluonPoint.addNeutron();

        assertTrue(gluonPoint.getNeutronsNeeded() == 0);
        assertFalse(gluonPoint.getNeutronsNeeded() == 2);

    }
    
}
