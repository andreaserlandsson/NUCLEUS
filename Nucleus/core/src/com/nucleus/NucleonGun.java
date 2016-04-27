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

    public NucleonGun(int width, int height, ArrayList<INucleon> nucleons){
        nucleonList = nucleons;
        this.height = height;
        this.width = width;
        arrayIndex = nucleonList.size() - 1;
    }
    //Temporary method
    public int getAmmoLeft(){
        return nucleonList.size();
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
            //a.setVelocity((int)(2*(Math.random()/10+0.01)), (int)(height/2*(Math.random()/10+0.01)));

        //Test -  super temp!!
        Vector velocityVect = new Vector(width/2,height/2).subtract(a.getPosition());
        a.setVelocity(velocityVect.getX(), velocityVect.getY());
        //a.setVelocity((int)(velocityVect.getX()*0.5), (int)(velocityVect.getY()*0.5));
        return a;
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
