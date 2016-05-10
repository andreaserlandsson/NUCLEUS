package com.nucleus.Controller;

import com.nucleus.Model.ILevel;
import com.nucleus.Model.Vector;

/**
 * Created by erik on 06/05/16.
 */
public class GameController implements ControllerState {

    ILevel level;
    Vector lastTouch = new Vector(0,0);

    public GameController(ILevel level){
        this.level = level;
    }

    public void touch(int screenX, int screenY, int pointer, int button){
        return;
    }

    public void drag(int screenX, int screenY, int pointer){
        Vector newTouch = new Vector(screenX, screenY);
        Vector delta = newTouch.subtract(this.lastTouch);
        float rotationAngle = findRotationAngle(delta);
        this.lastTouch = newTouch;
        level.getMolecule().setRotation(rotationAngle);
        return;
    }

    public float findRotationAngle(Vector delta){
        Vector r = lastTouch.subtract(new Vector(level.getWidth()/2.0f, level.getHeight()/2.0f));
        Vector rOrthogonal = new Vector(r.getY(), -r.getX());

        float effectiveRotationLength = delta.scalar(rOrthogonal.multiply((1/rOrthogonal.abs())));
        Vector rotationVector = rOrthogonal.multiply(1/rOrthogonal.abs()).multiply(effectiveRotationLength);
        float rotationAngle = (float) Math.atan(rotationVector.abs()/r.abs());

        return rotationAngle;
    }
}
