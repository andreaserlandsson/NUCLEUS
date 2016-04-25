package com.nucleus;


public class Molecule implements IMolecule {
    private int rotation = 0;
    private IGluonPoint[] gluons;

    public Molecule(IGluonPoint[] gluons){
        this.gluons = gluons;
    }

    public void setRotation(int rot){
        rotation = rot;
    }

    public int getRotation(){
        return rotation;
    }

    public boolean isFull() {//dummy value
        return false;
    }

}
