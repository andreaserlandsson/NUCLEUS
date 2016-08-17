package com.nucleus.model.level;

import com.nucleus.model.collision.ICollidable;
import com.nucleus.model.collision.Vector;
import com.nucleus.model.molecule.IMolecule;

/**
 * Created by andreaserlandsson on 05/08/16.
 */

//implement Icollidable so that it can colide
public class Shield implements IShield, ICollidable {
    private Vector centerPosition;
    private int radius;
    private int capacity;
    private int charge;


    /**
     * Creats a shield which on activation protects the molecuse absorbing the next 5
     * incoming nucleons.
     * @param levelWidth the width of the level
     * @param levelHeight the height of the level
     * @param charge the amount of times you will be able to activate the sheild
     */
    public Shield(int levelWidth, int levelHeight, int charge) {
        this.charge = charge;
        this.centerPosition = new Vector(levelWidth/2,levelHeight/2);

        capacity  = 0;
        radius = levelWidth/2 - 20;

    }

    public void decCap(){
            capacity --;
    }

    public int getCap() {
        return capacity;
    }

    public void setCap(int i) {
        capacity = i;
    }

    public int getRadius() {
        return radius;
    }

    public Vector getPosition() {
        return centerPosition;
    }

    public int getCharge() {
        return charge;
    }

    public void decCharge() {
        charge --;
    }
}