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

    public boolean isFull() { //dummy value
        for (IGluonPoint gluon : gluons) {
            if (!(gluon.isFull())) {
                return false;
            }
        }
        return true;
    }

    public Vector rotate(Vector center, Vector position, double angle) {
        angle = angle * Math.PI/180;
        Vector deltaPos = position.subtract(center);
        float nPosX = (float)(deltaPos.getX()*Math.cos(angle) + deltaPos.getY()*Math.sin(angle));
        float nPosY = (float)(-deltaPos.getX() * Math.sin(angle) + deltaPos.getY()*Math.cos(angle));
        return  new Vector(nPosX,nPosY);
    }

}
