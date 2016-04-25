package com.nucleus;

import java.util.*;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements INucleonGun{

    private ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    private int arrayIndex;

    public NucleonGun(ArrayList<INucleon> nucleons){
        nucleons = nucleonList;
        arrayIndex = nucleonList.size();
    }

    @Override
    public INucleon shoot(){ //return
        if (!isEmpty()) {
            INucleon a = nucleonList.get(arrayIndex);
            nucleonList.remove(arrayIndex);
            arrayIndex --;
            return a;
        } else{
            System.out.println("nucleonList is empty");
            return null; // hmmm vill vi verkligen detta?
        }
    }

    @Override
    public boolean isEmpty() {
        if (arrayIndex >= 0) {
            return false;
        } else {
            return true;
        }
    }
}
