package com.nucleus.Model;


public class Molecule implements com.nucleus.Model.IMolecule {
    private int rotation ;
    private com.nucleus.Model.IGluonPoint[] gluons;

    //VÄLDIGT TILLFÄLLIG!!!!!!!!
    Vector centerT = new Vector(280/2,512/2);
    //VÄLDIGT TILLFÄLLIG!!!!!!!!

    public Molecule(com.nucleus.Model.IGluonPoint[] gluons){
        this.gluons = gluons;
    }

    public void setRotation(int rot){
        rotation = rot;
        //temporärt
        for (com.nucleus.Model.IGluonPoint gluon : gluons) {
            Vector newPos = rotate(centerT, gluon.getPosition(), rot);
            gluon.setPosition(newPos.getX(), newPos.getY());
        }
    }



    public int getRotation(){
        return rotation;
    }

    public boolean isFull() { //dummy value
        for (com.nucleus.Model.IGluonPoint gluon : gluons) {
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
        return new Vector(nPosX, nPosY).add(center);
    }

}
