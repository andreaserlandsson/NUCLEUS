package mocks;

import com.nucleus.Model.molecule.IGluonPoint;
import com.nucleus.Model.molecule.IMolecule;
import com.nucleus.Model.Collisions.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockMolecule implements IMolecule {

    private float rotation = 0;
    private IGluonPoint[] gluons;
    private boolean isFull =false;

    public MockMolecule(IGluonPoint[] gluons){
        this.gluons = gluons;
    }

    public void setRotation(Vector lastTouch, Vector newTouch){
        rotation=1;
    }

    public float getRotation(){
        return rotation;
    }

    public boolean isFull() { //dummy value

        if (isFull) {
            return true;
        } else {
            return false;
        }
    }

    public void setFull(boolean full){
        if(full) {
            isFull = true;
        } else if (!full) {
            isFull = false;
        }
    }

    public void rotateGluon(IGluonPoint gluon, Vector v1, Vector v2, double d) {
        return;
    }

    @Override
    public IGluonPoint[] getGluons() {
        return gluons;
    }
}
