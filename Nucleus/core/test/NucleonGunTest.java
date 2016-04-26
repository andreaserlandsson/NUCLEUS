import com.nucleus.INucleon;
import org.junit.Test;
import java.util.ArrayList;
import mocks.MockNucleon;
import mocks.MockNucleonGun;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class NucleonGunTest {

    @Test
    public void testEmptyGun() {
        MockNucleon mockNucleon = new MockNucleon();
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        ArrayList<INucleon> emptyNucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        MockNucleonGun mockGun = new MockNucleonGun(nucleonList);
        MockNucleonGun emptyMockGun = new MockNucleonGun(emptyNucleonList);
        assertFalse(mockGun.isEmpty());
        assertTrue(emptyMockGun.isEmpty());
    }

    @Test
    public void testShoot() {
    }

    @Test
    public void testGunEmptyAfterShoot() {
        MockNucleon mockNucleon = new MockNucleon();
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        MockNucleonGun mockGun = new MockNucleonGun(nucleonList);
        assertFalse(mockGun.isEmpty());
        mockGun.shoot();
        assertTrue(mockGun.isEmpty());
    }

    @Test
    public void testMultipleShoots() {
        MockNucleon mockNucleon = new MockNucleon();
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        nucleonList.add(mockNucleon);
        nucleonList.add(mockNucleon);
        MockNucleonGun mockGun = new MockNucleonGun(nucleonList);
        mockGun.shoot();
        assertFalse(mockGun.isEmpty());
        mockGun.shoot();
        assertTrue(mockGun.isEmpty());
    }

    @Test
    public void testShootWhenEmpty(){
    }

    @Test
    public void testLoopForShoot() {
        MockNucleon mockNucleon = new MockNucleon();
        ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
        for (int i = 0; i < 10; i++) {
            nucleonList.add(mockNucleon);
        }
        MockNucleonGun mockGun = new MockNucleonGun(nucleonList);
        while(!(mockGun.isEmpty())){
            mockGun.shoot();
        }
        assertTrue(mockGun.isEmpty());
    }
}
