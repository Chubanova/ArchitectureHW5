package com.chubanova.changevelocity;

import com.chubanova.UObject;
import com.chubanova.move.Vector;

public class ChangeVelocityAdapter implements ChangeVelocityAble{

    UObject u;

    public ChangeVelocityAdapter(UObject u) {
        this.u = u;
    }

    @Override
    public Vector getVelocity() {
        return (Vector) u.getProperty("Velocity");
    }

    @Override
    public void setVelocity(Vector v) {
        u.setProperty("Velocity", v);

    }

    @Override
    public int getDirection() {
        return (int) u.getProperty("Direction");
    }

    @Override
    public int getDirectionNumbers() {
        return (int) u.getProperty("DirectionsNumber");
    }

}
