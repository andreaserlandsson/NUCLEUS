package com.nucleus.Model;


import com.badlogic.gdx.Gdx;

public class Molecule implements IMolecule {
    private float rotation;
    public IGluonPoint[] gluons;

    //Todo change from hardcoded values
    Vector centerT = new Vector(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);

    public Molecule(IGluonPoint[] gluons){
        this.gluons = gluons;
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
