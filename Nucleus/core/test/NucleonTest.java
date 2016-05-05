import com.nucleus.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonTest {

    @Test
    public void testUpdate() {
        Nucleon nucleon = new Nucleon(new Vector(1, 1), new Vector(2, 2));
        nucleon.update(100);
        assertTrue(nucleon.getPosition().getX() == 201 && nucleon.getPosition().getY() == 201);
    }

    @Test
    public void testSettersGetters(){
        Nucleon nucleon = new Nucleon(new Vector(1, 1), new Vector(1, 1));
        nucleon.setPosition(10, 10);
        nucleon.setVelocity(20, 20);
        assertTrue(nucleon.getPosition().getX() == 10 && nucleon.getPosition().getY() == 10);
        assertTrue(nucleon.getVelocity().getX() == 20 && nucleon.getVelocity().getY() == 20);
    }

    @Test
    public void testRadius(){
        Nucleon nucleon = new Nucleon(new Vector(1, 1), new Vector(1, 1));
        assertTrue(nucleon.getRadius() == 0); // this is a dummy value and might change later on
    }
}
