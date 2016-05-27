package com.nucleus.Model.particles;

import com.nucleus.Model.collisions.ICollidable;
import com.nucleus.Model.collisions.Vector;

/**
 * Created by erik on 19/04/16.
 */
public class Nucleon implements INucleon, ICollidable {

    private Vector position;
    private Vector velocity;
    private final int RADIUS = 10;   //Sizes will be used for collision detection purposes

    public Nucleon(){
    }

    public Nucleon(Vector position, Vector vector){
        this.position = position;
        this.velocity = vector;
    }

    public void update(float delta){
        position = position.add(velocity.multiply(delta));
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
