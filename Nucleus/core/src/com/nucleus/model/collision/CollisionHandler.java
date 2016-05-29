package com.nucleus.model.collision;

/**
 * Collision handler for two collidable objects.
 * Used to check collisions between a gluon point and an airborne nucleon.
 */
public class CollisionHandler {

    /**
     * @param c1 collidable object number one, usually a gluon.
     * @param c2 collidable object number two, usually a nucleon.
     * @return returns true if a collision occurs.
     */
    public static boolean collision(ICollidable c1, ICollidable c2){
        float distance = c1.getPosition().subtract(c2.getPosition()).abs();
        if((distance <= c1.getRadius() + c2.getRadius()))
            return true;
        return false;
    }
}
