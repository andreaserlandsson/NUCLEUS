package com.nucleus;

/**
 * Created by erik on 19/04/16.
 */
public class Nucleon implements  INucleon {

    private Vector position;
    private Vector velocity;
    private final int radius = 0;   //Dummy value. Sizes will be used for collision detection purposes
                                    //and will be properly determined later.

    public Nucleon(){

    }

    public Nucleon(Vector position, Vector vector){
        this.position = position;
        this.velocity = vector;
    }

    public void update(float delta){
        position = position.add(velocity.multiply(delta));
        for () { //gå igenom alla gluon points
            if (true){ //kolla ifall det finns någon collision mellan gluon pointen och nucleonen
                //gluon pointen addproton eller addneutron
                //remove nucleonen från airborn
            }
        }
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
        return radius;
    }
}
