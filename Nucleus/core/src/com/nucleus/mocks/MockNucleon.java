package com.nucleus.mocks;

import com.nucleus.INucleon;
import com.nucleus.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockNucleon implements INucleon {
    private Vector position;
    private Vector velocity;
    private final int radius = 0;   //Dummy value. Sizes will be used for collision detection purposes
    //and will be properly determined later.
    private boolean isVisible = false;

    public Vector getPosition(){
        return position;
    }
    public Vector getVelocity(){
        return velocity;
    }


    public void setPosition(int x, int y){
        position.setCoordinates(x, y);
    }
    public void setVelocity(int x, int y){
        velocity.setCoordinates(x, y);
    }
}
