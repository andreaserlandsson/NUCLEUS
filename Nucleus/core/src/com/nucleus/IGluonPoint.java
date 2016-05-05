package com.nucleus;


public interface IGluonPoint {
    boolean isFull();
    Vector getPosition();
    void setPosition(float x, float y);
    int getRadius();
    boolean addProton();
    int getProtonsNeeded();
    boolean addNeutron();
    int getNeutronsNeeded();
}
