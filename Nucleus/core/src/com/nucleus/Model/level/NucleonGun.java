package com.nucleus.Model.level;

import com.nucleus.Model.collisions.Vector;
import com.nucleus.Model.particles.INucleon;
import com.nucleus.Model.particles.Neutron;
import com.nucleus.Model.particles.Proton;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by erik on 19/04/16.
 */
public class NucleonGun implements INucleonGun {

    private ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    private int arrayIndex;
    private int width;
    private int height;
    private int difficultyMultiplier;

    public NucleonGun(int width, int height, ArrayList<INucleon> nucleons, int difficultyMultiplier){

        nucleonList = nucleons;
        this.height = height;
        this.width = width;
        arrayIndex = nucleonList.size() - 1;
        this.difficultyMultiplier = difficultyMultiplier;
    }

    @Override
    public int getProtonsInGun(){
        int nbrOfProtons = 0;
        for(int i = 0; i < nucleonList.size(); i++){
            if(nucleonList.get(i).getClass().equals(Proton.class)){
                nbrOfProtons++;
            }
        }
        return nbrOfProtons;
    }

    @Override
    public int getNeutronsInGun(){
        int nbrOfNeutrons = 0;
        for(int i = 0; i < nucleonList.size(); i++){
            if(nucleonList.get(i).getClass().equals(Neutron.class)){
                nbrOfNeutrons++;
            }
        }
        return nbrOfNeutrons;
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
        a.setVelocity(difficultyMultiplier*velocityVect.getX()/3, difficultyMultiplier*velocityVect.getY()/3);
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
