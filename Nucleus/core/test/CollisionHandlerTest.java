import com.nucleus.CollisionHandler;
import com.nucleus.GluonPoint;
import com.nucleus.IGluonPoint;
import com.nucleus.INucleon;
import com.nucleus.Nucleon;
import com.nucleus.Vector;

import static  org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mocks.MockGluon;
import mocks.MockNucleon;

/**
 * Created by mirandabannsgard on 16-04-26.
 */
public class CollisionHandlerTest {

    @Test
    public void testOfCollisionBetweenGluonAndNucleon(){
        Vector v1 = new Vector(1,1);
        Vector v2 = new Vector(5,5);
        IGluonPoint gluon = new MockGluon(v1,1,1);//should not collide
        INucleon nucleon = new MockNucleon(v2,1,1);
        assertFalse(CollisionHandler.collision(gluon,nucleon));

        IGluonPoint gluon2 = new MockGluon(v1,1,1);//should collide, and then return true
        INucleon nucleon2 = new MockNucleon(v2,1,1);
        assertTrue(CollisionHandler.collision(gluon2,nucleon2));

    }
    
}
