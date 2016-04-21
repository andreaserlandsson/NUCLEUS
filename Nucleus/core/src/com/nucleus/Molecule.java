package com.nucleus;


public class Molecule implements IMolecule {
    private int rotation = 0;
    private GluonPoint[] gluons;

    public Molecule(GluonPoint[] gluons){
        this.gluons = gluons;
    }

    public void setRotation(int rot){
        rotation = rot;
    }

    public int getRotation(){
        return rotation;
    }

    public boolean moleculeFilled() {//dummy value
        return false;
    }

}
