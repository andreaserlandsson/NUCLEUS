package Model;

import com.nucleus.Model.GluonPoint;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.Collisions.Vector;

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
    public void testGetPosition(){
        Vector position = new Vector(10,10);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertTrue(gluonPoint.getPosition() == position);
    }

    @Test
    public void testGetY(){
        Vector position = new Vector(5,5);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertFalse(gluonPoint.getY() == 10);
        assertTrue(gluonPoint.getY() == 5);
    }

    @Test
    public void testGetX(){
        Vector position = new Vector(15,15);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertFalse(gluonPoint.getX() == 5);
        assertTrue(gluonPoint.getX() == 15);
    }

    @Test
    public void testSetPosition(){
        Vector position = new Vector(3,3);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertTrue(gluonPoint.getPosition().getX() == 3);
        assertTrue(gluonPoint.getPosition().getY() == 3);
        gluonPoint.setPosition(new Vector(4,4));
        assertFalse(gluonPoint.getPosition().getX() == 3);
        assertFalse(gluonPoint.getPosition().getY() == 3);
        assertTrue(gluonPoint.getPosition().getX() == 4);
        assertTrue(gluonPoint.getPosition().getY() == 4);
    }

    @Test
    public void testGetRadius(){
        Vector position = new Vector(2,2);
        IGluonPoint gluonPoint = new GluonPoint(position, 0, 0);
        assertFalse(gluonPoint.getRadius() == 0);
        assertTrue(gluonPoint.getRadius() == 10);
    }

    @Test
    public void testAddNeutron() {
        Vector position = new Vector(1,1);
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
    public void testGetNeutronsNeeded(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 1, 1);
        assertTrue(gluonPoint.getNeutronsNeeded() == 1);
        gluonPoint.addNeutron();
        assertFalse(gluonPoint.getNeutronsNeeded() == 1);
        assertTrue(gluonPoint.getNeutronsNeeded() == 0);
    }

    @Test
    public void testGetProtonsNeeded(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 1, 1);
        assertTrue(gluonPoint.getProtonsNeeded() == 1);
        gluonPoint.addProton();
        assertFalse(gluonPoint.getProtonsNeeded() == 1);
        assertTrue(gluonPoint.getProtonsNeeded() == 0);
    }

    @Test
    public void testGetCurrentNeutrons(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 3, 3);
        assertTrue(gluonPoint.getCurrentNeutrons() == 0);
        gluonPoint.addNeutron();
        assertFalse(gluonPoint.getCurrentNeutrons() == 0);
        assertTrue(gluonPoint.getCurrentNeutrons() == 1);
        gluonPoint.addNeutron();
        assertFalse(gluonPoint.getCurrentNeutrons() == 1);
        assertTrue(gluonPoint.getCurrentNeutrons() == 2);
        gluonPoint.addProton();
        assertFalse(gluonPoint.getCurrentNeutrons() == 3);
        assertTrue(gluonPoint.getCurrentNeutrons() == 2);
    }

    @Test
    public void testGetCurrentProtons(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 3, 3);
        assertTrue(gluonPoint.getCurrentProtons() == 0);
        gluonPoint.addProton();
        assertFalse(gluonPoint.getCurrentProtons() == 0);
        assertTrue(gluonPoint.getCurrentProtons() == 1);
        gluonPoint.addProton();
        assertFalse(gluonPoint.getCurrentProtons() == 1);
        assertTrue(gluonPoint.getCurrentProtons() == 2);
        gluonPoint.addNeutron();
        assertFalse(gluonPoint.getCurrentProtons() == 3);
        assertTrue(gluonPoint.getCurrentProtons() == 2);
    }


    @Test
    public void testGetMaxNeutrons(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 1, 4);
        assertFalse(gluonPoint.getMaxNeutrons() == 1);
        assertTrue(gluonPoint.getMaxNeutrons() == 4);
    }

    @Test
    public void testGetMaxProtons(){
        Vector position = new Vector(1,1);
        IGluonPoint gluonPoint = new GluonPoint(position, 2, 3);
        assertFalse(gluonPoint.getMaxProtons() == 3);
        assertTrue(gluonPoint.getMaxProtons() == 2);
    }






    
}
