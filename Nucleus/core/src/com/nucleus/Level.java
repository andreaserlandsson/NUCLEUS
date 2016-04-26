package com.nucleus;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float dummyUpdateVariable = 1;

    private INucleonGun gun;
    private List<INucleon> airborneNucleons = new ArrayList<INucleon>();
    private IMolecule molecule;


    public Level(int width, int height, INucleonGun gun, IMolecule molecule){
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
    }

    public INucleonGun getNucleonGun(){
        return gun;
    }

    public List<INucleon> getAirborneNucleons(){
        return airborneNucleons;
    }


    public void addAirborneNucleon(INucleon nucleon){
        airborneNucleons.add(nucleon);
    }

    public void outOfBoundsCheck(){ // checks if any nucleons in airborne Nucleons is out of bounds
        for (int i=0; i<airborneNucleons.size(); i++){
            INucleon nucleon = airborneNucleons.get(i);
            int x = nucleon.getPosition().getX();
            int y = nucleon.getPosition().getY();
            if (x + nucleon.getRadius()>width || x-nucleon.getRadius()<0 ||
                    y+nucleon.getRadius()>height || y-nucleon.getRadius()<0){
                airborneNucleons.remove(i);
                i--;
            }
        }
    }
    //TODO: add difficulty multiplier which alters how often the gun shoots and how fast the nucleons fly
    //TODO: add a collision check that also evaluates which gluon point to fill
    public void update(float delta){
        runTime += delta;
        for(INucleon nucleon : airborneNucleons){
            nucleon.update(delta);
        }
        outOfBoundsCheck();

        if(runTime - lastUpdateTime > dummyUpdateVariable) {
            lastUpdateTime = runTime;
            airborneNucleons.add(gun.shoot());
        }
    }

}