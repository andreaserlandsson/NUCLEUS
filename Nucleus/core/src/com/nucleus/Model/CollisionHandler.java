package com.nucleus.Model;

public class CollisionHandler {

    public static boolean collision(com.nucleus.Model.IGluonPoint gluonPoint, com.nucleus.Model.INucleon nucleon){

        float distance = gluonPoint.getPosition().subtract(nucleon.getPosition()).abs();

        if((distance <= gluonPoint.getRadius() + nucleon.getRadius()))
            return true;
        return false;

    }

}
