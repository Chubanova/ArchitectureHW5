package com.chubanova.changevelocity;

import com.chubanova.move.Vector;

public interface ChangeVelocityAble {
    Vector getVelocity();

    void setVelocity(Vector newValue);

    int getDirection();

    int getDirectionNumbers();
}
