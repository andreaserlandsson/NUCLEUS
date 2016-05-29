package com.nucleus.model.level;

import com.nucleus.model.collision.Vector;
import com.nucleus.model.particles.INucleon;
import com.nucleus.model.particles.Neutron;
import com.nucleus.model.particles.Proton;

import java.util.ArrayList;
import java.util.Random;

public class NucleonGun implements INucleonGun {

    private ArrayList<INucleon> nucleonList = new ArrayList<INucleon>();
    private int arrayIndex;
    private int width;
    private int height;
    private int difficultyMultiplier;

    /**
     * Creates a nucleon gun that shoots nucleons in to the level. The gun is level specific,
     * with different ammo for each level.
     * @param width the width of the level.
     * @param height the height of the level.
     * @param nucleons the amount of nucleons that the gun as as ammo.
     * @param difficultyMultiplier the difficultyMultiplier for the level, at what speed the
     *                             nucleons will be shot with.
     */
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

    /**
     * Shoots a new nucleon to the level. The position is set randomly between one of the four
     * edges of the screen.
     * @return the said nucleon.
     */
    @Override
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
        velocityVect = velocityVect.multiply(1/velocityVect.abs()*difficultyMultiplier);
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
