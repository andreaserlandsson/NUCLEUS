package com.nucleus.Model;

import com.nucleus.Model.Collisions.Vector;

public interface IMolecule {

    void setRotation(Vector v1, Vector v2);
    float getRotation();
    boolean isFull();
    void rotateGluon(IGluonPoint gluon, Vector v1, Vector v2, double d);
    IGluonPoint[] getGluons();
}
