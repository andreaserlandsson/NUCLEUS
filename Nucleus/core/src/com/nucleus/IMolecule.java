package com.nucleus;

public interface IMolecule {

    void setRotation(int r);
    int getRotation();
    boolean isFull();
    Vector rotate(Vector v1,Vector v2, double d);


}
