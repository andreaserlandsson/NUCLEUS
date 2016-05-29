package com.nucleus.model.level;

import com.nucleus.model.particles.INucleon;

public interface INucleonGun {
    INucleon shoot(); //should take a delta value, to time the guns shots
    boolean isEmpty();
    int getProtonsInGun();
    int getNeutronsInGun();
}
