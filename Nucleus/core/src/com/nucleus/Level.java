package com.nucleus;

import java.util.List;

public class Level{
    private int level;
    private List<Nucleon> nucleons;
    private Molecule molecule;

    public Level(int level, List<Nucleon> nucleons, Molecule molecule){
        this.level = level;
        this.nucleons = nucleons;
        this.molecule = molecule;
    }

    public List<Nucleon> getNucleons(){
        return nucleons;
    }

}