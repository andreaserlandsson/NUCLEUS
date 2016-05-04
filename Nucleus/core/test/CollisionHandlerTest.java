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
        Vector gluonPos = new Vector(1,1);
        Vector nucleonPos = new Vector(5,5);
        Vector nucleonVel = new Vector(1,1);
        IGluonPoint gluon = new MockGluon(gluonPos,1,1);//should not collide, not even close
        INucleon nucleon = new MockNucleon(nucleonPos, nucleonVel);
        assertFalse(CollisionHandler.collision(gluon,nucleon));

        IGluonPoint gluon2 = new MockGluon(gluonPos,1,1);//on the same position, should collide
        nucleonPos.setCoordinates(1,1);
        INucleon nucleon2 = new MockNucleon(nucleonPos,nucleonVel);

        assertTrue(CollisionHandler.collision(gluon2,nucleon2));
        gluonPos.setCoordinates(3,3);
        IGluonPoint gluon3 = new MockGluon(gluonPos,1,1);
        //radius on MockGluon is 2
        nucleonPos.setCoordinates(6,6);
        INucleon nucleon3 = new MockNucleon(nucleonPos,nucleonVel);
        //radius on Mocknucleon is 2

        //Distance between 3,3 and 6,6 is less than 4 --> collison
        assertTrue(CollisionHandler.collision(gluon3,nucleon3)); //collision = true
    }
    
}
