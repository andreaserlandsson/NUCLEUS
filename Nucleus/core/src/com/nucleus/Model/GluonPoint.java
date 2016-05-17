package com.nucleus.Model;

public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int currentProtons;
    private int currentNeutrons;
    private int maxProtons;
    private int maxNeutrons;

    private final int radius = 10; // dummy value will be calibrated later

    public GluonPoint(Vector positions, int maxProtons, int maxNeutrons){
        this.position = positions;
        this.maxProtons = maxProtons;
        this.maxNeutrons = maxNeutrons;
        currentNeutrons = 0;
        currentProtons = 0;
    }

    public boolean isFull() {
        return getProtonsNeeded() == 0 && getNeutronsNeeded() == 0;
    }

    public Vector getPosition(){
        return position;
    }

    public float getX(){
        return position.getX();
    }

    public float getY(){
        return position.getY();
    }

    public void setPosition(float x, float y){
        position.setCoordinates(x, y);
    }

    public int getRadius(){
        return radius;
    }

    public void addNeutron() { // if this returns false the game is lost
        currentNeutrons++;
    }

    public void addProton() { // if this returns false the game is lost
        currentProtons++;
    }

    public int getNeutronsNeeded() {
        return maxNeutrons - currentNeutrons;
    }

    public int getProtonsNeeded() {
        return maxProtons - currentProtons;
    }

    public int getCurrentNeutrons() { return currentNeutrons; }

    public int getCurrentProtons() { return currentProtons; }

    public int getMaxNeutrons() { return maxNeutrons; }

    public int getMaxProtons() { return maxProtons; }
}
