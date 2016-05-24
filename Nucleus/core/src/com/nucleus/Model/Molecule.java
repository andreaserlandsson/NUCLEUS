package com.nucleus.Model;


public class Molecule implements IMolecule {
    private float rotation=0;
    private int width;
    private int height;
    float rotationMultiplier = 40; //A constant that is used to scale the rotation angle

    public IGluonPoint[] gluons;

    public Molecule(int width, int height,IGluonPoint[] gluons){
        this.gluons = gluons;
        this.width = width;
        this.height = height;
    }

    public IGluonPoint getGluonPoint(int i) {
        return gluons[i];
    }

    public int getNrOfGluonPoint(){
        return gluons.length;
    }

//    public void setRotation(float rot){
//        rotation = rotation + rot;
//        //temporärt
//        for (IGluonPoint gluon : gluons) {
//            Vector newPos = rotate(centerT, gluon.getPosition(), rot);
//            gluon.setPosition(newPos.getX(), newPos.getY());
//        }
//    }

    public void setRotation(com.nucleus.Utils.Vector lastTouch, com.nucleus.Utils.Vector newTouch){
        float angle = calculateRotationAngle(lastTouch, newTouch);
        rotation = rotation + angle;

        for(IGluonPoint gluon : gluons){
            rotateGluon(gluon, new com.nucleus.Utils.Vector(width / 2, height / 2), gluon.getPosition(), angle);
        }

    }

    private float calculateRotationAngle(com.nucleus.Utils.Vector lastTouch, com.nucleus.Utils.Vector newTouch){
        com.nucleus.Utils.Vector delta = newTouch.subtract(lastTouch);
        com.nucleus.Utils.Vector r = lastTouch.subtract(new com.nucleus.Utils.Vector(width/2.0f, height/2.0f));
        com.nucleus.Utils.Vector rOrthogonal = new com.nucleus.Utils.Vector(r.getY(), -r.getX());
        com.nucleus.Utils.Vector rOrthoUnit = rOrthogonal.multiply((1/rOrthogonal.abs()));
        float effectiveRotationLength = delta.scalar(rOrthoUnit);
        com.nucleus.Utils.Vector rotationVector = rOrthoUnit.multiply(effectiveRotationLength);
        float rotationAngle = (float) Math.atan(rotationVector.abs()/r.abs());
        if (effectiveRotationLength>0)
            rotationAngle = -rotationAngle;
        return rotationMultiplier * rotationAngle;
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

    public void rotateGluon(IGluonPoint gluon, com.nucleus.Utils.Vector center, com.nucleus.Utils.Vector position, double angle) {
        angle = -angle * Math.PI/180;
        com.nucleus.Utils.Vector deltaPos = position.subtract(center);
        float nPosX = (float)(deltaPos.getX()*Math.cos(angle) + deltaPos.getY()*Math.sin(angle));
        float nPosY = (float)(-deltaPos.getX() * Math.sin(angle) + deltaPos.getY()*Math.cos(angle));
        com.nucleus.Utils.Vector newPos = new com.nucleus.Utils.Vector(nPosX, nPosY).add(center);
        gluon.setPosition(newPos);
    }

    @Override
    public IGluonPoint[] getGluons() {
        return gluons;
    }
}
