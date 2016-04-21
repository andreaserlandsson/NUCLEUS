package com.nucleus;

/**
 * Created by erik on 19/04/16.
 */
public class GluonPoint {

    private Vector position;
    private int protonsNeeded;
    private int neutronsNeeded;

    public GluonPoint(int posX, int posY, int pNeeded, int nNeeded){
        this.position = new Vector(posX, posY);
        this.protonsNeeded = pNeeded;
        this.neutronsNeeded = nNeeded;
    }

    public Vector getPosition(){
        return position;
    }

}
