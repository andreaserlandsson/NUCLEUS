package com.nucleus.model.collision;

public class CollisionHandler {
    public static boolean collision(ICollidable c1, ICollidable c2){
        float distance = c1.getPosition().subtract(c2.getPosition()).abs();
        if((distance <= c1.getRadius() + c2.getRadius()))
            return true;
        return false;
    }
}
