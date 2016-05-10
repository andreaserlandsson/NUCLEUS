package mocks;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockGluon implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;
    private final int radius = 2; //Dummy value will be defined later


    public MockGluon(Vector v, int pNeeded, int nNeeded){
        this.position = v;
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    public boolean isFull(){
        return true;
    }
    public Vector getPosition(){
        return position;
    }

    @Override
    public void setPosition(float x, float y) {
        position.setCoordinates(x,y);

    }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public boolean addProton() {
        protonsNeeded --;
        return true;
    }

    @Override
    public int getProtonsNeeded() {
        return protonsNeeded;
    }

    @Override
    public boolean addNeutron() {
        return true;
    }

    @Override
    public int getNeutronsNeeded() {
        return 0;
    }
}
