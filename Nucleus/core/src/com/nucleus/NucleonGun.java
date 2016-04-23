package com.nucleus;

import java.util.ArrayList;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements INucleonGun{
    public NucleonGun(ArrayList<INucleon> nucleons){

    }
    /*
    The following are super temporary dummy-methods to satisfy the interface INucleonGun
     */
    public INucleon shoot(){return new Nucleon(1,1,1,1);}

    public boolean isEmpty(){return false;}
}
