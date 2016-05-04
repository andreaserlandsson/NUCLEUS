import com.nucleus.GluonPoint;
import com.nucleus.Vector;

import org.junit.Test;

/**
 * Created by andreaserlandsson on 26/04/16.
 */
public class GluonPointTest {

    @Test
    public void testGluonPointFilled() {
        Vector v = new Vector(0,0);
        GluonPoint gluonPoint = new GluonPoint(v, 2, 2);
        gluonPoint.addNeutron();
        gluonPoint.addProton();

        if (gluonPoint.getNeutronsNeeded() == gluonPoint.getProtonsNeeded()){
            System.out.println("This text should NOT be printed. This means the number of neutron is not equal to the number of protons whne it whould be");
        }

        if (gluonPoint.isFull()){
            System.out.println("This text should NOT be printed. This means the gluon point thinks it is full when it should not be full");
        }

        gluonPoint.addNeutron();

        if (gluonPoint.isFull()){
            System.out.println("This text should NOT be printed. This means the gluon point thinks it is full when it should not be full");
        }

        gluonPoint.addProton();

        if (gluonPoint.addProton()){
            System.out.println("This text should NOT be printed. This means we have added more protons then is allowed");
        } else if (gluonPoint.addNeutron()) {
            System.out.println("This text should NOT be printed. This means we have added more neutrons then is allowed");
        } else if (!gluonPoint.isFull()){
            System.out.println("This text should NOT be printed. This means the gluon point is not filled even though it should be");
        } else {
            System.out.println("Everything worked");
        }
    }
}
