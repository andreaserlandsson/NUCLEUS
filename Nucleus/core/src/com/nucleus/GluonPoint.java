package com.nucleus;


public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int protons;
    private int neutronsNeeded;
    private int neutrons;
    private final int radius = 0; // dummy value will be calibrated later

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.position = new Vector(posX, posY);
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    @Override
    public boolean isFull() {
        if (protons == protonsNeeded && neutrons == neutronsNeeded) {
            return true;
        } else {
            return false;
        }
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

    @Override
    public boolean addNeutron() { // if this returns false the game is lost
        if (!isFull() && neutrons > neutronsNeeded) {
            neutrons++;
            return true;
        } else {
            return false;
        }
    }

    public int getNeutrons() {
        return neutrons;
    }

    @Override
    public boolean addProton() { // if this returns false the game is lost
        if (!isFull() && protons > protonsNeeded) {
            protons++;
            return true;
        } else {
            return false;
        }
    }

    public int getProtons() {
        return protons;
    }
}
