import com.nucleus.INucleon;
import com.nucleus.INucleonGun;
import com.nucleus.NucleonGun;
import com.nucleus.Vector;

import org.junit.Test;

import java.util.ArrayList;

import mocks.MockNucleon;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class NucleonGunTest {
    //Mock variables for width and heigth. Will be correct regardless of values.
    private int width = 200;
    private int heigth = 400;

    //Test for empty gun, and that is indeed empty when empty, and not empty when not.
    @Test
    public void testEmptyGun() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        ArrayList<INucleon> emptyNucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        INucleonGun mockGun = new NucleonGun(width, heigth,nucleonList);
        INucleonGun emptyMockGun = new NucleonGun(width, heigth,emptyNucleonList);
        assertFalse(mockGun.isEmpty());
        assertTrue(emptyMockGun.isEmpty());
    }

    //Test that a gun is empty after shooting its only ammo.
    @Test
    public void testGunEmptyAfterShoot() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        assertFalse(mockGun.isEmpty());
        mockGun.shoot();
        assertTrue(mockGun.isEmpty());
    }

    //Test that a gun is not empty after if there is still ammo left.
    @Test
    public void testMultipleShoots() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        nucleonList.add(mockNucleon);
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        mockGun.shoot();
        assertFalse(mockGun.isEmpty());
        mockGun.shoot();
        assertTrue(mockGun.isEmpty());
    }

    //Test that if you shoot when list is empty, you get out of bounds error.
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testShootWhenEmpty(){
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        assertTrue(mockGun.isEmpty());
        mockGun.shoot();
        mockGun.shoot();
        assertTrue(mockGun.isEmpty());
        }


    //Test that gun is empty when have shot all ammo that it has got.
    @Test
    public void testLoopForShoot() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        for (int i = 0; i < 10; i++) {
            nucleonList.add(mockNucleon);
        }
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        while(!(mockGun.isEmpty())){
            mockGun.shoot();
        }
        assertTrue(mockGun.isEmpty());
    }



    @Test
    public void testShootPosition() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        INucleon mockShotNucleon;
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        mockShotNucleon = mockGun.shoot();
        assertTrue(mockShotNucleon.getPosition().getX() <= width);
        assertTrue(mockShotNucleon.getPosition().getX() >= 0);
        assertTrue(mockShotNucleon.getPosition().getY() <= heigth);
        assertTrue(mockShotNucleon.getPosition().getY() >= 0);
    }

    //Test for gun setting velocity and that it is always positive and greater than zero (0).
    @Test
    public void testShootVelocity() {
        Vector nucleonPos = new Vector(0,0);
        Vector nucleonVel = new Vector(0,0);
        INucleon mockNucleon = new MockNucleon(nucleonPos,nucleonVel);
        INucleon mockShotNucleon;
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        INucleonGun mockGun = new NucleonGun(width,heigth,nucleonList);
        mockShotNucleon = mockGun.shoot();
        assertTrue(mockShotNucleon.getVelocity().getX() > 0);
        assertTrue(mockShotNucleon.getVelocity().getY() > 0);
    }
}
