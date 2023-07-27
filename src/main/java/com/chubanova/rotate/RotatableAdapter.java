package com.chubanova.rotate;

import com.chubanova.UObject;

public class RotatableAdapter implements Rotatable{
    UObject o;

    public RotatableAdapter(UObject o) {
        this.o = o;
    }


    @Override
    public int getDirection() {
        return (int) o.getProperty("Direction");
    }

    @Override
    public int getAngularVelocity() {
        return (int) o.getProperty("AngularVelocity");
    }

    @Override
    public void setDirection(int newV) {
        o.setProperty("Direction", newV);
    }

    @Override
    public int getDirectionsNumber() {
        return (int) o.getProperty("DirectionsNumber");

    }
}
