package com.nucleus.model.particles;

import com.nucleus.model.collision.ICollidable;
import com.nucleus.model.collision.Vector;

public class Nucleon implements INucleon, ICollidable {

    private Vector position;
    private Vector velocity;

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
        int RADIUS = 10;
        return RADIUS;
    }
}
