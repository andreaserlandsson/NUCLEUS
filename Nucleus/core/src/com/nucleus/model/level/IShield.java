package com.nucleus.model.level;

import com.nucleus.model.collision.Vector;
import com.nucleus.model.molecule.IMolecule;

/**
 * Created by andreaserlandsson on 05/08/16.
 */
public interface IShield {
    void decCap();
    int getCap();
    void setCap(int i);
    int getRadius();
    int getCharge();
    void decCharge();
    Vector getPosition();
}
