package com.chubanova.move;

import com.chubanova.Command;

public class Move implements Command {
    Movable m;

    public Move(Movable m) {
        this.m = m;
    }

    public void execute() {
        try {
            Vector position = m.getPosition();
            if (position == null)
                throw new RuntimeException("Не сдвинуть объект, у которого невозможно прочитать положение в пространстве!");
            Vector velocity = m.getVelocity();
            if (velocity == null)
                throw new RuntimeException("Не сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости!");
            m.setPosition(Vector.plus(position, velocity));
        } catch (Exception e) {
            throw new RuntimeException("Не сдвинуть объект, у которого невозможно изменить положение в пространстве");
        }
    }

}
