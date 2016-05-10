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

    public void setRotation(float r){
        rotation=r;
    }

<<<<<<< HEAD
    @Override
    public int getNrOfGluonPoint() {
        return gluons.length;
    }

    @Override
    public IGluonPoint getGluonPoint(int i) {
        return gluons[i];
    }

    @Override
    public void setRotation(float r) {

    }

=======
>>>>>>> develop
    public float getRotation(){
        return rotation;
    }

    public boolean isFull() { //dummy value
        return false;
    }

    public Vector rotate(Vector v1, Vector v2, double d) {
        return null;
    }
}
