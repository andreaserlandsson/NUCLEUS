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
        Vector v = new Vector(1,1);
        IGluonPoint gluon = new MockGluon(v,1,1);//should not collide, not even close
        INucleon nucleon = new MockNucleon(5,5,1,1);
        assertFalse(CollisionHandler.collision(gluon,nucleon));

        IGluonPoint gluon2 = new MockGluon(v,1,1);//on the same position, should collide
        INucleon nucleon2 = new MockNucleon(1,1,1,1);

        assertTrue(CollisionHandler.collision(gluon2,nucleon2));
        Vector v2 = new Vector(3,3);
        IGluonPoint gluon3 = new MockGluon(v2,1,1);
        //radius on MockGluon is 2
        INucleon nucleon3 = new MockNucleon(6,6,1,1);
        //radius on Mocknucleon is 2
        
        //Distance between 3,3 and 6,6 is less than 4 --> collison
        assertTrue(CollisionHandler.collision(gluon3,nucleon3)); //collision = true
    }
    
}
