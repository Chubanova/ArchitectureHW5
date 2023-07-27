package com.chubanova.rotate;

import com.chubanova.Command;

public class Rotate implements Command {
    Rotatable r;
    public Rotate(Rotatable r) {
        this.r = r;
    }
    public void execute() {
        r.setDirection(
                (r.getDirection()+r.getAngularVelocity())%r.getDirectionsNumber());
    }

}
