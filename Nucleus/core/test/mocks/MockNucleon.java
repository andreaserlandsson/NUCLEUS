package mocks;

import com.nucleus.Model.INucleon;
import com.nucleus.Utils.Vector;


public class MockNucleon implements INucleon {
    private Vector position;
    private Vector velocity;
    private final int radius = 3;   //Dummy value. Sizes will be used for collision detection purposes
                                    //and will be properly determined later.
    private boolean isVisible = false;

    public MockNucleon(){

    }

    public MockNucleon(Vector pos, Vector vel){
        this.position = pos;
        this.velocity = vel;
    }

    public void update(float delta){
        position = position.add(velocity.multiply(delta));
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    public Vector getPosition(){
        return position;
    }
    public Vector getVelocity(){
        return velocity;
    }


    public void setPosition(float x, float y){
        position.setCoordinates(x, y);
    }
    public void setVelocity(float x, float y){
        velocity.setCoordinates(x, y);
    }

    @Override
    public int getRadius() {
        return radius;
    }
}
