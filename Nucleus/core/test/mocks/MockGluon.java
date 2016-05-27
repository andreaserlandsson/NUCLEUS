package mocks;

import com.nucleus.Model.collisions.ICollidable;
import com.nucleus.Model.molecule.IGluonPoint;
import com.nucleus.Model.collisions.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockGluon implements IGluonPoint, ICollidable {

    private Vector position;
    private int currentProtons;
    private int currentNeutrons;
    private int maxProtons;
    private int maxNeutrons;
    private final int radius = 2; // dummy value will be calibrated later

    public MockGluon(Vector gluonPositions, int pNeeded, int nNeeded){
        this.position = gluonPositions;
        this.maxProtons = pNeeded;
        this.maxNeutrons = nNeeded;
        currentNeutrons = 0;
        currentProtons = 0;
    }



    public boolean isFull() { //this method is needed for the Molecule.isFull()-test
        return getNeutronsNeeded() == 0 && getProtonsNeeded() == 0;

    }

    @Override
    public Vector getPosition() {
        return position;
    }

    public float getX(){
        return position.getX();
    }

    public float getY(){
        return position.getY();
    }


    public void setPosition(Vector vect){
        position.setCoordinates(vect.getX(), vect.getY());
    }


    public int getRadius(){
        return radius;
    }

    public void addProton() { // if this returns false the game is lost
        currentProtons++;
    }

    //Need this method implemented for the MoleculeTest
    public void addNeutron() { // if this returns false the game is lost
        currentNeutrons++;
    }

    public int getNeutronsNeeded() {
        return maxNeutrons - currentNeutrons;
    }

    public int getProtonsNeeded() {
        return maxProtons - currentNeutrons;

    }

    public int getCurrentNeutrons() {
        return currentNeutrons;
    }

    public int getCurrentProtons() {
        return currentProtons;
    }

    public int getMaxNeutrons() {
        return maxNeutrons;
    }

    public int getMaxProtons() {
        return maxProtons;
    }

}
