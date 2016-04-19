package com.nucleus;

/**
 * Created by erik on 19/04/16.
 */
public class Nucleon {

    private int posX;
    private int posY;
    private int velX;
    private int velY;
    private final int width = 0;   //Dummy value. Sizes will be used for collision detection purposes
    private final int height = 0;  //and will be properly determined later.
    private boolean isVisible = false;

    public Nucleon(){

    }

    public Nucleon(int posX, int posY, int velX, int velY){
        this.posX=posX;
        this.posY=posY;
        this.velX=velX;
        this.velY=velY;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public int getVelX(){
        return velX;
    }

    public int getVelY(){
        return velY;
    }

    public void setPosition(int x, int y){
        posY = y;
        posX = x;
    }

    public void setVelocity(int x, int y){
        velX = x;
        velY = y;
    }
}
