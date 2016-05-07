package com.nucleus.Model;

/**
 * Created by erik on 22/04/16.
 */
public interface INucleonGun {
    com.nucleus.Model.INucleon shoot(); //should take a delta value, to time the guns shots
    boolean isEmpty();

}
