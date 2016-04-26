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
        arrayIndex = nucleonList.size() - 1;
    }

    @Override
    public INucleon shoot() {
        if (!isEmpty()) {
            INucleon a = nucleonList.get(arrayIndex);
            nucleonList.remove(arrayIndex);
            arrayIndex --;

            /*
            config.width = 288;
		    config.height = 512;
             */
            //sets the start position for the nucleon
            int x = (int)Math.random()*3;
            switch(x){
                //längs med toppen
                case 0:
                    a.setPosition(288/(int)Math.random()*287+1,0); // We do not divide by zero
                    break;

                //längs med botten
                case 1:
                    a.setPosition(288/(int)Math.random()*287+1, 512); // We do not divide by zero
                    break;

                //lång med vänster långsida
                case 2:
                    a.setPosition(0,512/(int)Math.random()*511 +1); // We do not divide by zero
                    break;

                //längs med höger långsida
                case 4:
                    a.setPosition(288, 512/(int)Math.random()*511 +1); // We do not divide by zero
                    break;

                default:
                    break;
            }

            //sets the next position for the nucleon ELLER?
            a.setVelocity((int)(288/2*(Math.random()/10+0.01)), (int)(512/2*(Math.random()/10+0.01)));

            return a;
        } else {
            System.out.println("nucleonList is empty");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (arrayIndex >= 0) {
            return false;
        } else {
            System.out.println("nucleonList is empty");
            return true;
        }
    }
}
