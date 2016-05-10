package mocks;

import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.Vector;


/**
 * Created by mirandabannsgard on 16-05-09.
 */
public class MockGluonForMoleculeTest implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;
    private final int radius = 2; // dummy value will be calibrated later

    public MockGluonForMoleculeTest(Vector gluonPositions, int pNeeded, int nNeeded){
        this.position = gluonPositions;
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }



    public boolean isFull() { //this method is needed for the Molecule.isFull()-test
        return protonsNeeded == 0 && neutronsNeeded == 0;
    }

    @Override
    public com.nucleus.Model.Vector getPosition() {
        return null;
    }


    public void setPosition(float x, float y){
        position.setCoordinates(x, y);
    }


    public int getRadius(){
        return radius;
    }


    //Need this method implemented for the MoleculeTest
    public boolean addNeutron() {
        if (!isFull() && neutronsNeeded > 0) {
            neutronsNeeded--;

            return true;
        } else {
            return false;
        }
    }

    public int getNeutronsNeeded() {
        return 0;
    }

    //Need this method implemented for the MoleculeTest
    public boolean addProton() {

        if (!isFull() && protonsNeeded > 0) {
            protonsNeeded--;
            return true;
        } else {
            return false;
        }
    }

    public int getProtonsNeeded() {
        return 0;
    }
}