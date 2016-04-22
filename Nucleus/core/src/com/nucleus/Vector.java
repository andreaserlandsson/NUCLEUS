package com.nucleus;

/**
 * Created by erik on 21/04/16.
 */
public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void add(Vector vect){
        this.x = this.x + vect.getX();
        this.y = this.y + vect.getY();
    }

    public void multiply(float t){
        this.x = (int)(x*t);
        this.y = (int)(y*t);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }



}
