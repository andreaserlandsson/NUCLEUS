package com.nucleus;

public class CollisionHandler {


    public static boolean hasCollide(GluonPoint gluonPoint, Nucleon nucleon){

        double distance;
        int xPosGluonPoint = gluonPoint.getPosition().getX();
        int yPosGluonPoint = gluonPoint.getPosition().getY();
        int xPosNucleon = nucleon.getPosition().getX();
        int yPosNucleon = nucleon.getPosition().getY();

        distance = Math.sqrt((xPosGluonPoint-xPosNucleon)^2 + (yPosGluonPoint-yPosNucleon)^2);


        if(distance < gluonPoint.getRadius() + nucleon.getRadius()){
            return true;
        }else{
            return false;
        }

    }

    



}
