package com.nucleus;


public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int protonAmnt;
    private int neutronsNeeded;
    private int neutronAmnt;
    private final int radius = 0; // dummy value will be calibrated later

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.position = new Vector(posX, posY);
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    public boolean isFull() {
        return protonAmnt == protonsNeeded && neutronAmnt == neutronsNeeded;
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
        if (!isFull() && neutronsNeeded > neutronAmnt) {
            neutronAmnt++;
            return true;
        } else {
            return false;
        }
    }

    public int getNeutronAmnt() {
        return neutronAmnt;
    }

    public boolean addProton() { // if this returns false the game is lost
        if (!isFull() && protonsNeeded > protonAmnt) {
            protonAmnt++;
            return true;
        } else {
            return false;
        }
    }

    public int getProtonAmnt() {
        return protonAmnt;
    }
}
