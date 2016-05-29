package com.nucleus.model.particles;

import com.nucleus.model.collision.Vector;

/**
 * Created by paki on 4/21/16.
 */
public interface INucleon {

    Vector getPosition();
    Vector getVelocity();

    void update(float delta);

    void setPosition(float x, float y);
    void setVelocity(float x, float y);

    int getRadius();

}