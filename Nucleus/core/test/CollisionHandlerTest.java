import com.nucleus.CollisionHandler;
import com.nucleus.GluonPoint;
import com.nucleus.IGluonPoint;
import com.nucleus.INucleon;
import com.nucleus.Nucleon;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Created by mirandabannsgard on 16-04-26.
 */
public class CollisionHandlerTest {

    @Test
    public void testOfCollisionBetweenGluonAndNucleon(){
        IGluonPoint gluon = new GluonPoint(4,5,1,1);
        INucleon nucleon = new Nucleon(5,4,1,1);
        assertTrue(CollisionHandler.collision(gluon,nucleon));

    }
    
}
