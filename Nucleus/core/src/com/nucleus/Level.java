package com.nucleus;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel { //add level size
    private int width;
    private int height;
    private NucleonGun gun;
    private List<Nucleon> airborneNucleons = new ArrayList<Nucleon>();
    private Molecule molecule;

    public Level(int width, int height, NucleonGun gun, Molecule molecule){
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
    }

    public List<Nucleon> getNucleons(){
        return airborneNucleons;
    }

    public void addAirborneNucleon(){
        Nucleon nucleon = new Proton();//gun.shoot();
        airborneNucleons.add(nucleon);
    }

    public void outOfBoundsCheck(){ // checks if any nucleons in airbornNucleons is out of bounds

    }

}