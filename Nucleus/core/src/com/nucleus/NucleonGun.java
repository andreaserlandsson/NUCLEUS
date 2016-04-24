package com.nucleus;

import java.util.*;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun {

    private ArrayList<Nucleon> nucleonList = new ArrayList<Nucleon>();
    private int arrayIndex;


    public NucleonGun(ArrayList<Nucleon> nucleons){
        nucleons = nucleonList;
        arrayIndex = nucleonList.size();
    }

    public boolean shoot(){ //what sould this return?
        if (nucleonList.get(arrayIndex) != null) {
            Nucleon a = nucleonList.get(arrayIndex);
            nucleonList.remove(arrayIndex);
            arrayIndex --;
            
            //ta en random start pos
            //  x-led och y-led (ett led mste va maximerat ås inget )
            //vektro....?
            return true;
        } else{
            System.out.println("nucleonList is empty");
            return false;
        }
    }
}
