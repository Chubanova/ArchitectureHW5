package com.chubanova.rotate;

public interface Rotatable {
    int getDirection();
    int getAngularVelocity();
    void setDirection(int newV);
    int getDirectionsNumber();
}
