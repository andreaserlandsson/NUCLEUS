package com.nucleus;

import java.util.*;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements INucleonGun{

    private ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    private int arrayIndex;
    private int width;
    private int height;

    public NucleonGun(int width, int heigth, ArrayList<INucleon> nucleons){
        nucleonList = nucleons;
        this.height = heigth;
        this.width = width;
        arrayIndex = nucleonList.size() - 1;
    }

    @Override
    public INucleon shoot() {
            INucleon a = nucleonList.get(arrayIndex);
            nucleonList.remove(arrayIndex);
            arrayIndex --;

            //sets the start position for the nucleon
            int x = (int)(Math.random()*3);
            switch(x){
                //längs med toppen
                case 0:
                    a.setPosition((int)(Math.random()*width) , 0); // We do not divide by zero
                    break;

                //längs med botten
                case 1:
                    a.setPosition((int)(Math.random()*width) , height); // We do not divide by zero
                    break;

                //lång med vänster långsida
                case 2:
                    a.setPosition(0 , (int)(Math.random()*height)); // We do not divide by zero
                    break;

                //längs med höger långsida
                case 3:
                    a.setPosition(width, (int)(Math.random()*height)); // We do not divide by zero
                    break;

                default:
                    break;
            }

            //sets the next position for the nucleon ELLER?
            a.setVelocity((int)(width/2*(Math.random()/10+0.01)), (int)(height/2*(Math.random()/10+0.01)));
            return a;
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
