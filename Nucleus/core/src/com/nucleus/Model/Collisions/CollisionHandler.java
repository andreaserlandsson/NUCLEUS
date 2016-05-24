package com.nucleus.Model.Collisions;

public class CollisionHandler {

    public static boolean collision(ICollidable c1, ICollidable c2){

        float deltaX = c1.getX()-c2.getX();
        float deltaY = c1.getY()-c2.getY();


        float distance = (float)Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

        if(distance <= c1.getRadius()+c2.getRadius()){
            return true;
        }else{
            return false;
        }

    }

}
