package com.nucleus;

/**
 * Created by paki on 4/21/16.
 */
public interface INucleon {

    Vector getPosition();
    Vector getVelocity();


    void setPosition(int x, int y);
    void setVelocity(int x, int y);

    int getRadius();

}
