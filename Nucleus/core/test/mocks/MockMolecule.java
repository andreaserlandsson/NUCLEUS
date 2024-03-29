package mocks;

import com.nucleus.model.molecule.IGluonPoint;
import com.nucleus.model.molecule.IMolecule;
import com.nucleus.model.collision.Vector;

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
