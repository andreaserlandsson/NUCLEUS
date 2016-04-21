package com.nucleus;


public class GluonPoint implements IGluonPoint {

    private int posX;
    private int posY;
    private int protonsNeeded;
    private int neutronsNeeded;

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.posX = posX;
        this.posY = posY;
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
