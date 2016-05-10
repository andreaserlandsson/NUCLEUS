package com.nucleus.Model;

import com.nucleus.*;

public interface IMolecule {

    int getNrOfGluonPoint();
    IGluonPoint getGluonPoint(int i);
    void setRotation(float r);
    float getRotation();
    boolean isFull();
    Vector rotate(Vector v1, Vector v2, double d);


}
