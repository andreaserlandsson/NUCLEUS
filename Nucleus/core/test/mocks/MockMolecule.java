package mocks;

import com.nucleus.IGluonPoint;
import com.nucleus.IMolecule;

/**
 * Created by erik on 22/04/16.
 */
public class MockMolecule implements IMolecule {

    private int rotation = 0;
    private IGluonPoint[] gluons;

    public MockMolecule(IGluonPoint[] gluons){
        this.gluons = gluons;
    }

    public void setRotation(int r){
        rotation=r;
    }

    public int getRotation(){
        return rotation;
    }

    public boolean isFull() { //dummy value
        return false;
    }

}
