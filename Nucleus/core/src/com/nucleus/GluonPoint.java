package com.nucleus;


public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
<<<<<<< HEAD
    private int neutronsNeeded;
=======
    private int protons = 0;
    private int neutronsNeeded;
    private int neutrons = 0;
>>>>>>> GluonPointTest
    private final int radius = 0; // dummy value will be calibrated later

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.position = new Vector(posX, posY);
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
<<<<<<< HEAD
        if (!isFull() && neutronsNeeded > 0) {
            neutronsNeeded--;
=======
        if (!isFull() && neutrons < neutronsNeeded) {
            neutrons++;
>>>>>>> GluonPointTest
            return true;
        } else {
            return false;
        }
    }

    public int getNeutronsNeeded() {
        return neutronsNeeded;
    }

    public boolean addProton() { // if this returns false the game is lost
<<<<<<< HEAD
        if (!isFull() && protonsNeeded > 0) {
            protonsNeeded--;
=======
        if (!isFull() && protons < protonsNeeded) {
            protons++;
>>>>>>> GluonPointTest
            return true;
        } else {
            return false;
        }
    }

    public int getProtonsNeeded() {
        return protonsNeeded;
    }
}
