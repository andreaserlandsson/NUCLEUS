package com.nucleus.model.particles;

import com.nucleus.model.collision.Vector;

public interface INucleon {

    Vector getPosition();

    Vector getVelocity();

    /**
     * Nucleon's position is updated according to velocity and last position.
     * @param delta The time past since the last update.
     */
    void update(float delta);


    void setPosition(float x, float y);
    void setVelocity(float x, float y);

    int getRadius();

}
