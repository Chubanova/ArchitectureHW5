package com.chubanova.changevelocity;

import com.chubanova.Command;
import com.chubanova.move.Vector;

public class ChangeVelocityCommand implements Command {
    ChangeVelocityAble changeVelocityAble;

    public ChangeVelocityCommand(ChangeVelocityAble changeVelocityAble) {
        this.changeVelocityAble = changeVelocityAble;
    }

    @Override
    public void execute() {
        Vector currentVelocity = changeVelocityAble.getVelocity();
        int angleDegress = 360 * changeVelocityAble.getDirection() /
                changeVelocityAble.getDirectionNumbers();
        double angle = Math.toRadians(angleDegress);
        double angleVelocity = Math.sqrt(Math.pow(currentVelocity.getX(),2) +
                Math.pow(currentVelocity.getY(),2));

        Vector newVelocity = new Vector(
                (int)(angleVelocity * Math.cos(angle)),
                (int)(angleVelocity * Math.sin(angle))
        );

        changeVelocityAble.setVelocity(newVelocity);
    }

}
