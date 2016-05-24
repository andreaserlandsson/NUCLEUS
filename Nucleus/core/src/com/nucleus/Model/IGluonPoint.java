package com.nucleus.Model;


public interface IGluonPoint {
    boolean isFull();
    com.nucleus.Utils.Vector getPosition();
    void setPosition(com.nucleus.Utils.Vector vect);
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
