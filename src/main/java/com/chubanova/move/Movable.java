package com.chubanova.move;


public interface Movable {

    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector newV);
}
