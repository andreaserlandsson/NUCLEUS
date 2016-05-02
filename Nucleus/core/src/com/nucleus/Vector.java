package com.nucleus;

/**
 * Created by erik on 21/04/16.
 */
public class Vector {
    private float x;
    private float y;

    public Vector(float x, float y){
        this.x=x;
        this.y=y;
    }

    public void setCoordinates(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector vect){
        return new Vector(x + vect.getX(), y + vect.getY());
    }

    public Vector subtract(Vector vect){
        return new Vector(x - vect.getX(), y - vect.getY());
    }

    public Vector multiply(float t){
        return new Vector(x*t, y*t);
    }

    public float abs(){
        return (float)Math.sqrt(x*x + y*y);
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }



}
