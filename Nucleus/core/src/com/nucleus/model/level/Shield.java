package com.nucleus.model.level;

import com.nucleus.model.collision.Vector;
import com.nucleus.model.molecule.IMolecule;

/**
 * Created by andreaserlandsson on 05/08/16.
 */
public class Shield implements IShield{
    IMolecule molecule;
    ILevel level;
    private Vector centerPosition;
    private int radius;
    private int shieldCapacity;

    public Shield(IMolecule molecule, ILevel level, int shieldCapacity) {
        this.molecule = molecule;
        this.level = level;
        this.shieldCapacity = shieldCapacity;

        if( molecule.getWidth() > molecule.getHeight()) {
            radius = molecule.getWidth();
        } else {
            radius = molecule.getHeight();
        }
        this.centerPosition = new Vector((float)level.getHeight()/2,(float)level.getWidth()/2);
    }

    public void decShieldCap(){
        shieldCapacity --;
    }

    public int getShieldCap(){
        return shieldCapacity;
    }

}
