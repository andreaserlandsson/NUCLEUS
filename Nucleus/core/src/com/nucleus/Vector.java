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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
