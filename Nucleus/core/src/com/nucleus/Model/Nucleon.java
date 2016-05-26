package com.nucleus.Model;

import com.nucleus.Model.Collisions.ICollidable;
import com.nucleus.Model.Collisions.Vector;

/**
 * Created by erik on 19/04/16.
 */
public class Nucleon implements INucleon, ICollidable {

    private Vector position;
    private Vector velocity;
    private final int RADIUS = 10;   //Dummy value. Sizes will be used for collision detection purposes
                                    //and will be properly determined later.
    public Nucleon(){
    }

    public Nucleon(Vector position, Vector vector){
        this.position = position;
        this.velocity = vector;
    }

    public void update(float delta){
        position = position.add(velocity.multiply(delta));
    }

    public float getX(){
        return position.getX();
    }

    public float getY(){
        return position.getY();
    }

    public Vector getPosition(){
        return position;
    }

    public Vector getVelocity(){
        return velocity;
    }

    public void setPosition(float x, float y){
        position.setCoordinates(x, y);
    }

    public void setVelocity(float x, float y) {
        velocity.setCoordinates(x, y);
    }

    public int getRadius(){
        return RADIUS;
    }
}
