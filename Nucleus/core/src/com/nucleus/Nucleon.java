package com.nucleus;

/**
 * Created by erik on 19/04/16.
 */
public class Nucleon {

    private Vector position;
    private Vector velocity;
    private final int width = 0;   //Dummy value. Sizes will be used for collision detection purposes
    private final int height = 0;  //and will be properly determined later.
    private boolean isVisible = false;

    public Nucleon(){

    }

    public Nucleon(int posX, int posY, int velX, int velY){
        this.position = new Vector(posX, posY);
        this.velocity = new Vector(velX, velY);
    }

    public Vector getPosition(){
        return position;
    }

    public Vector getVelocity(){
        return velocity;
    }

    public void setPosition(int x, int y){
        position.setCoordinates(x, y);
    }

    public void setVelocity(int x, int y) {
        velocity.setCoordinates(x, y);
    }
}
