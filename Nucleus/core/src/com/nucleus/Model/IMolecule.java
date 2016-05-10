package com.nucleus.Model;

public interface IMolecule {

    void setRotation(float r);
    float getRotation();
    boolean isFull();
    Vector rotate(Vector v1, Vector v2, double d);
    IGluonPoint[] getGluons();
}
