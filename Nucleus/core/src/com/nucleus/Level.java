package com.nucleus;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel { //add level size
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

    public List<INucleon> getNucleons(){
        return airborneNucleons;
    }

    public void addAirborneNucleon(){
        INucleon nucleon = new Proton();//gun.shoot();
    }

    public void outOfBoundsCheck(){ // checks if any nucleons in airbornNucleons is out of bounds

    }

}