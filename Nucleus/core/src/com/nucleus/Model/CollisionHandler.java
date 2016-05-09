package com.nucleus.Model;

public class CollisionHandler {

    public static boolean collision(IGluonPoint gluonPoint, INucleon nucleon){

        float distance = gluonPoint.getPosition().subtract(nucleon.getPosition()).abs();

        if((distance <= gluonPoint.getRadius() + nucleon.getRadius()))
            return true;
        return false;

    }

}
