package com.nucleus.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements com.nucleus.Model.INucleonGun {

    private ArrayList<com.nucleus.Model.INucleon> nucleonList = new ArrayList<com.nucleus.Model.INucleon>();
    private int arrayIndex;
    private int width;
    private int height;

    public NucleonGun(int width, int height, ArrayList<com.nucleus.Model.INucleon> nucleons){
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
    //TODO: some sort of normalization of the velocity vector for easier manipulation according to difficultyMultiplier
    public com.nucleus.Model.INucleon shoot() {
        com.nucleus.Model.INucleon a = nucleonList.get(arrayIndex);
        nucleonList.remove(arrayIndex);
        arrayIndex --;

        //sets the start position for the nucleon
        Random rand = new Random();
        int x = rand.nextInt(4);

        switch(x){
            //along the top screen edge
            case 0:
                a.setPosition(rand.nextInt(width) , height);
                break;
            //along the bottom screen edge
            case 1:
                a.setPosition(rand.nextInt(width) , 0);
                break;

            //along the left screen edge
            case 2:
                a.setPosition(0 , rand.nextInt(height));
                break;

            //along the right screen edge
            case 3:
                a.setPosition(width, rand.nextInt(height));
                break;

            default:
                break;
            }

        Vector velocityVect = new Vector(width/2.0f,(float)height/2.0f).subtract(a.getPosition());
        a.setVelocity(velocityVect.getX(), velocityVect.getY());
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
