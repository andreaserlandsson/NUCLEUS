package com.nucleus;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int width;
    private int height;
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
            int x = airborneNucleons.get(i).getPosition().getX();
            int y = airborneNucleons.get(i).getPosition().getY();
            if (x>width || x<0 || y>height || y<0){
                airborneNucleons.remove(i);
                i--;
            }
        }
    }

}