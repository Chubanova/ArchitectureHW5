package com.chubanova.move;


import com.chubanova.UObject;

public class MovableAdapter implements Movable{


    UObject o;
    public MovableAdapter(UObject o) {
        this.o = o;
    }


    @Override
    public Vector getPosition() {
        return (Vector) o.getProperty("Position");

    }

    @Override
    public Vector getVelocity() {
        return (Vector) o.getProperty("Velocity");

//        int d = (int) o.getProperty("Direction");
//        int n = (int) o.getProperty("DirectionsNumber");
//        int v = (int) o.getProperty("Velocity");
//        return new Vector(
//                v * Math.cos((double)d/360*n),
//                v * Math.sin((double)d/360*n)
//                );

    }

    @Override
    public void setPosition(Vector newV) {
        o.setProperty("Position", newV);

    }
}
