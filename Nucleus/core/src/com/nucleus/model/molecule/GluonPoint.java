package com.nucleus.model.molecule;

import com.nucleus.model.collision.ICollidable;
import com.nucleus.model.collision.Vector;

public class GluonPoint implements IGluonPoint, ICollidable {

    private Vector position;
    private int currentProtons;
    private int currentNeutrons;
    private int maxProtons;
    private int maxNeutrons;
    private int RADIUS;

    /**
     * Constructor for GluonPoint,
     * @param positions The position of the gluonpoint
     * @param maxProtons Maximum number of protons the gluonpoint can have
     * @param maxNeutrons Maximum number of neutrons the gluonpoint can have
     */
    public GluonPoint(Vector positions, int maxProtons, int maxNeutrons){
        this.position = positions;
        this.maxProtons = maxProtons;
        this.maxNeutrons = maxNeutrons;
        RADIUS = 10;
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

    public void setPosition(Vector vect){
        position.setCoordinates(vect.getX(), vect.getY());
    }

    public int getRadius(){
        return RADIUS;
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
