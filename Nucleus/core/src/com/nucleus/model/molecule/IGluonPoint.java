package com.nucleus.model.molecule;


import com.nucleus.model.collision.Vector;

public interface IGluonPoint {
    boolean isFull();
    Vector getPosition();
    float getX();
    float getY();
    void setPosition(Vector vect);
    int getRadius();
    void addProton();
    int getProtonsNeeded();
    void addNeutron();
    int getNeutronsNeeded();
    public int getCurrentNeutrons();
    public int getCurrentProtons();
    public int getMaxNeutrons();
    public int getMaxProtons();
}
