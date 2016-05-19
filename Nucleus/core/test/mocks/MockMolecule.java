package mocks;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockMolecule implements IMolecule {

    private float rotation = 0;
    private IGluonPoint[] gluons;

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
        return false;
    }

    public void rotateGluon(IGluonPoint gluon, Vector v1, Vector v2, double d) {
        return;
    }

    @Override
    public IGluonPoint[] getGluons() {
        return gluons;
    }
}
