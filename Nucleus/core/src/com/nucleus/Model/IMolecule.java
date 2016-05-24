package com.nucleus.Model;

public interface IMolecule {

    void setRotation(com.nucleus.Utils.Vector v1, com.nucleus.Utils.Vector v2);
    float getRotation();
    boolean isFull();
    void rotateGluon(IGluonPoint gluon, com.nucleus.Utils.Vector v1, com.nucleus.Utils.Vector v2, double d);
    IGluonPoint[] getGluons();
}
