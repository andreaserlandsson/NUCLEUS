package com.nucleus.model.level;

import com.nucleus.model.collision.ICollidable;
import com.nucleus.model.collision.Vector;
import com.nucleus.model.molecule.IMolecule;

/**
 * Created by andreaserlandsson on 05/08/16.
 */

//implement Icollidable so that it can colide
public class Shield implements IShield, ICollidable {
    IMolecule molecule;
    private Vector centerPosition;
    private int radius;
    private int capacity;
    private int charge;

    public Shield(IMolecule molecule, int levelWidth, int levelHeight, int charge) {
        this.molecule = molecule;
        this.charge = charge;
        this.centerPosition = new Vector(levelWidth/2,levelHeight/2);

        capacity  = 0;
        radius = levelWidth/2 - 20;


        /*
        if( molecule.getWidth() > molecule.getHeight()) {
            radius = molecule.getWidth();
        } else {
            radius = molecule.getHeight();
        }
        */
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