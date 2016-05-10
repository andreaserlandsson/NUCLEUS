package com.nucleus.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements INucleonGun {

    private ArrayList<INucleon> nucleonList = new ArrayList<com.nucleus.Model.INucleon>();
    private int arrayIndex;
    private int width;
    private int height;
    private int difficultMultiplier;

    public NucleonGun(int width, int height, ArrayList<INucleon> nucleons, int difficultMultiplier){
        nucleonList = nucleons;
        this.height = height;
        this.width = width;
        arrayIndex = nucleonList.size() - 1;
        this.difficultMultiplier = difficultMultiplier;
    }
    //Temporary method
    public int getAmmoLeft(){
        return nucleonList.size();
    }

    @Override
    //TODO: some sort of normalization of the velocity vector for easier manipulation according to difficultyMultiplier
    public INucleon shoot() {
        INucleon a = nucleonList.get(arrayIndex);
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

        Vector velocityVect = new Vector(width/2.0f,height/2.0f).subtract(a.getPosition());
        a.setVelocity(difficultMultiplier*velocityVect.getX()/3, difficultMultiplier*velocityVect.getY()/3);
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
