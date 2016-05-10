package com.nucleus.Model;


public class Molecule implements IMolecule {
    private float rotation;
    private int width;
    private int height;
    public IGluonPoint[] gluons;
    private Vector centerT;
    public Molecule(int width, int heigth,IGluonPoint[] gluons){
        this.gluons = gluons;
        centerT = new Vector(width/2, heigth/2);

    }


    public void setRotation(float rot){
        rotation = rotation + rot;

        //temporärt
        for (IGluonPoint gluon : gluons) {
            Vector newPos = rotate(centerT, gluon.getPosition(), rot);
            gluon.setPosition(newPos.getX(), newPos.getY());
        }
    }

    public float getRotation(){
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
        angle = -angle * Math.PI/180;
        Vector deltaPos = position.subtract(center);
        float nPosX = (float)(deltaPos.getX()*Math.cos(angle) + deltaPos.getY()*Math.sin(angle));
        float nPosY = (float)(-deltaPos.getX() * Math.sin(angle) + deltaPos.getY()*Math.cos(angle));
        return new Vector(nPosX, nPosY).add(center);
    }

    public IGluonPoint[] getGluons(){
        return gluons;
    }

}
