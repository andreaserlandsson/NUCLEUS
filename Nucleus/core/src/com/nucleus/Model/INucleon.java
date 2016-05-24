package com.nucleus.Model;

/**
 * Created by paki on 4/21/16.
 */
public interface INucleon {

    com.nucleus.Utils.Vector getPosition();
    com.nucleus.Utils.Vector getVelocity();

    void update(float delta);

    void setPosition(float x, float y);
    void setVelocity(float x, float y);

    int getRadius();

}
