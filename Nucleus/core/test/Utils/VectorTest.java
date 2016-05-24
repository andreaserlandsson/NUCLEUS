package Utils;

import org.junit.Test;
import com.nucleus.Utils.Vector;
import static org.junit.Assert.*;
/**
 * Created by mirandabannsgard on 16-05-05.
 */
public class VectorTest {

    Vector vector = new Vector(1,1);

    @Test
    public void testSetCoordinates(){
        vector.setCoordinates(2,2);

        assertFalse(vector.getX() == 1);
        assertFalse(vector.getY() == 1);

        assertTrue(vector.getX() == 2);
        assertTrue(vector.getY() == 2);

        assertFalse(vector.getX() != 2);
        assertFalse(vector.getY() != 2);
    }

    @Test
    public void testAdd(){
        Vector vector2 = new Vector(2,2);

        Vector vector3 = vector.add(vector2);

        assertTrue(vector3.getX() == vector2.getX()+vector.getX());
        assertTrue(vector3.getY() == vector2.getY()+vector.getY());

        assertFalse(vector3.getX() != 3.0);
        assertFalse(vector3.getY() != 3.0);

        assertFalse(vector.getX() == 2);
        assertFalse(vector.getY() == 2);
    }

    @Test
    public void testSubtract(){
        Vector vector4 = new Vector(4,4);
        Vector vector5 = new Vector(2,2);

        Vector vector6 = vector4.subtract(vector5);

        assertTrue(vector6.getX() == vector4.getX()-vector5.getX());
        assertTrue(vector6.getY() == vector4.getY()-vector5.getY());

        assertFalse(vector6.getX() != 2.0);
        assertFalse(vector6.getY() != 2.0);

        assertFalse(vector6.getX() == 5);
        assertFalse(vector6.getY() == 5);
    }

    @Test
    public void testMultiply(){
        Vector vector7 = new Vector(5,5);
        Float t = new Float(2);

        Vector vector8 = vector7.multiply(t);

        assertTrue(vector8.getX() == vector7.getX()*t);
        assertTrue(vector8.getY() == vector7.getY()*t);

        assertFalse(vector8.getX() != 10.0);
        assertFalse(vector8.getY() != 10.0);

        assertFalse(vector8.getX() == 5);
        assertFalse(vector8.getY() == 5);
    }

    @Test
    public void testAbs(){
        Vector vector9 = new Vector(3,4);

        Float m = vector9.abs();

        assertTrue(m == 5.0);
        assertFalse(m != 5.0);
        assertFalse(m == 2.0);
    }

    @Test
    public void testGetX(){
        Vector v11 = new Vector(1,1);
        assertTrue(v11.getX() == 1.0);
        assertFalse(v11.getX() != 1.0);
        assertFalse(v11.getX() == 2.0);
    }
    @Test
    public void testGetY(){
        Vector v12 = new Vector(1,1);
        assertTrue(v12.getX() == 1.0);
        assertFalse(v12.getX() != 1.0);
        assertFalse(v12.getX() == 2.0);
    }

    @Test
    public void testScalar() {

        Vector v13 = new Vector(1,2);
        Vector v14 = new Vector(2,3);

        assertFalse(v13.scalar(v13) != 5);
        assertTrue(v13.scalar(v13) == 5);

        assertFalse(v13.scalar(v14) != 8);
        assertTrue(v13.scalar(v14) == 8);

    }


}
