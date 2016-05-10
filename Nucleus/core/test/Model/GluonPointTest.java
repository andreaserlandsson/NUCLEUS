package Model;

import com.nucleus.Model.GluonPoint;
import com.nucleus.Model.Vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andreaserlandsson on 26/04/16.
 */
public class GluonPointTest {

    @Test
    public void testGluonPointFilled() {

        Vector position = new Vector(1, 1);
        GluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertFalse(gluonPoint.addNeutron());
        assertFalse(gluonPoint.addProton());
        assertTrue(gluonPoint.getNeutronsNeeded() == gluonPoint.getProtonsNeeded());
        assertTrue(gluonPoint.isFull());
    }

    @Test
    public void testAddProton() {
        Vector position = new Vector(1, 1);
        GluonPoint gluonPoint = new GluonPoint(position, 2, 0);
        assertFalse(gluonPoint.addNeutron());
        assertTrue(gluonPoint.addProton());
        assertFalse(gluonPoint.isFull());
        gluonPoint.addProton();
        assertTrue(gluonPoint.isFull());
    }

    @Test
    public void testAddNeutron() {
        Vector position = new Vector(1, 1);
        GluonPoint gluonPoint = new GluonPoint(position, 0, 2);
        assertFalse(gluonPoint.addProton());
        assertTrue(gluonPoint.addNeutron());
        assertFalse(gluonPoint.isFull());
        gluonPoint.addNeutron();
        assertTrue(gluonPoint.isFull());
    }
}
