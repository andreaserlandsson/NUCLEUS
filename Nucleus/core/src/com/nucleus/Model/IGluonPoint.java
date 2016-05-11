package com.nucleus.Model;


public interface IGluonPoint {
    boolean isFull();
    Vector getPosition();
    void setPosition(float x, float y);
    int getRadius();
    void addProton();
    int getProtonsNeeded();
    void addNeutron();
    int getNeutronsNeeded();
}
