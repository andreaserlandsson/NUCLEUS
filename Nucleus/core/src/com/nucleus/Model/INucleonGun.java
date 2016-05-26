package com.nucleus.Model;

/**
 * Created by erik on 22/04/16.
 */
public interface INucleonGun {
    INucleon shoot(); //should take a delta value, to time the guns shots
    boolean isEmpty();
    int getProtonsInGun();
    int getNeutronsInGun();
}
