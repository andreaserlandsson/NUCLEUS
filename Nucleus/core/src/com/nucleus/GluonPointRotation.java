package com.nucleus;


public class GluonPointRotation {

    public Vector rotateGluon(Vector center, Vector position, double angle) {
        angle = angle * Math.PI/180;
        float posX = position.getX()-center.getX();
        float posY = position.getY()-center.getY();

        double nPosX = posX*Math.cos(angle) + posY*Math.sin(angle);
        double nPosY = -posX * Math.sin(angle) + posY*Math.cos(angle);
        float newPosX = (float) nPosX;
        float newPosY = (float)nPosY;

        return  new Vector(newPosX,newPosY);
    }
}
