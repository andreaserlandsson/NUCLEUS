package com.nucleus.model.molecule;

import com.nucleus.model.collision.Vector;

public class Molecule implements IMolecule {
    private float rotation=0;
    private int width;
    private int height;
    private final float ROTATIONMULTIPLIER = 57; //A constant that is used to scale the rotation angle

    public IGluonPoint[] gluons;

    /**
     * Constructor for a molecule.
     * @param width The width of the molecule
     * @param height The height of the molecule
     * @param gluons List of all the gluonpoints the molecule contains
     */
    public Molecule(int width, int height,IGluonPoint[] gluons){
        this.gluons = gluons;
        this.width = width;
        this.height = height;
    }

    public void setRotation(Vector lastTouch, Vector newTouch){
        float angle = calculateRotationAngle(lastTouch, newTouch);
        rotation = rotation + angle;

        for(IGluonPoint gluon : gluons){
            rotateGluon(gluon, new Vector(width / 2, height / 2), gluon.getPosition(), angle);
        }

    }

    private float calculateRotationAngle(Vector lastTouch, Vector newTouch){
        Vector delta = newTouch.subtract(lastTouch);
        Vector r = lastTouch.subtract(new Vector(width/2.0f, height/2.0f));
        Vector rOrthogonal = new Vector(r.getY(), -r.getX());
        Vector rOrthoUnit = rOrthogonal.multiply((1/rOrthogonal.abs()));
        float effectiveRotationLength = delta.scalar(rOrthoUnit);
        Vector rotationVector = rOrthoUnit.multiply(effectiveRotationLength);
        float rotationAngle = (float) Math.atan(rotationVector.abs()/r.abs());
        if (effectiveRotationLength<0)
            rotationAngle = -rotationAngle;
        return ROTATIONMULTIPLIER * rotationAngle;
    }

    public float getRotation(){
        return rotation;
    }

    public boolean isFull() {
        for (IGluonPoint gluon : gluons) {
            if (!(gluon.isFull())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Rotates a gluon point with simple rotation algebra.
     * @param gluon the gluon point to be rotated.
     * @param center the center around which the gluon should be rotated.
     * @param position the current position of the gluon.
     * @param angle the angle of which the gluon will be rotated.
     */
    public void rotateGluon(IGluonPoint gluon, Vector center, Vector position, double angle) {
        angle = -angle * Math.PI/180;
        Vector deltaPos = position.subtract(center);
        float nPosX = (float)(deltaPos.getX()*Math.cos(angle) + deltaPos.getY()*Math.sin(angle));
        float nPosY = (float)(-deltaPos.getX() * Math.sin(angle) + deltaPos.getY()*Math.cos(angle));
        Vector newPos = new Vector(nPosX, nPosY).add(center);
        gluon.setPosition(newPos);
    }

    @Override
    public IGluonPoint[] getGluons() {
        return gluons;
    }
}
