package com.nucleus;

public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;

    private final int radius = 0; // dummy value will be calibrated later

    public GluonPoint(Vector positions, int pNeeded, int nNeeded){
        this.position = positions;
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    public boolean isFull() {
        return protonsNeeded == 0 && neutronsNeeded == 0;
    }

    public Vector getPosition(){
        return position;
    }

    public void setPosition(int x, int y){
        position.setCoordinates(x, y);
    }

    public int getRadius(){
        return radius;
    }


    public boolean addNeutron() { // if this returns false the game is lost
        if (!isFull() && neutronsNeeded > 0) {
            neutronsNeeded--;

            return true;
        } else {
            return false;
        }
    }

    public int getNeutronsNeeded() {
        return neutronsNeeded;
    }

    public boolean addProton() { // if this returns false the game is lost

        if (!isFull() && protonsNeeded > 0) {
            protonsNeeded--;
            return true;
        } else {
            return false;
        }
    }

    public int getProtonsNeeded() {
        return protonsNeeded;
    }
}
