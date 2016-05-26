package com.nucleus.Model;

import com.nucleus.Model.Collisions.Vector;

/**
 * Created by paki on 4/21/16.
 */
public interface INucleon {

    Vector getPosition();
    Vector getVelocity();

    void update(float delta);

    float getX();
    float getY();

    void setPosition(float x, float y);
    void setVelocity(float x, float y);

    int getRadius();

}
