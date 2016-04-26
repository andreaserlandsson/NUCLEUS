package com.nucleus;


public interface IGluonPoint {
    boolean isFull();
    Vector getPosition();
    void setPosition(int x, int y);
    int getRadius();
}
