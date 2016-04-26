package com.nucleus;


public class GluonPoint implements IGluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;
    private final int radius = 0; // dummy value will be calibrated later

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.position = new Vector(posX, posY);
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    @Override
    public boolean isFull() {
        return false;
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

}
