package mocks;

import com.nucleus.IGluonPoint;
import com.nucleus.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockGluon implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;
    private final int radius = 2; //Dummy value will be defined later

    public MockGluon(Vector gluonPositions, int pNeeded, int nNeeded){
        this.position = new Vector(gluonPositions.getX(), gluonPositions.getY());
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    public boolean isFull(){
       return true;
    }
    public Vector getPosition(){
        return position;
    }
    public void setPosition(int x, int y){
        position.setCoordinates(x, y);
    }

    @Override
    public int getRadius() {
        return radius;
    }

    @Override
    public boolean addProton() {
        return true;
    }

    @Override
    public int getProtonsNeeded() {
        return 0;
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
