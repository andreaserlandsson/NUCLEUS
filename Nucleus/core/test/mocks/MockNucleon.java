package mocks;

import com.nucleus.INucleon;
import com.nucleus.Vector;

/**
 * Created by erik on 22/04/16.
 */
public class MockNucleon implements INucleon {
    private Vector position;
    private Vector velocity;
    private final int radius = 3;   //Dummy value. Sizes will be used for collision detection purposes
                                    //and will be properly determined later.
    private boolean isVisible = false;

    public MockNucleon(){

    }

    public MockNucleon(int posX, int posY, int velX, int velY){
        this.position = new Vector(posX, posY);
        this.velocity = new Vector(velX, velY);
    }

    public void update(float delta){
        position = position.add(velocity.multiply(delta));
    }

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

    @Override
    public int getRadius() {
        return radius;
    }
}
