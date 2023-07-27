package com.chubanova.fuel;

import com.chubanova.Command;
import com.chubanova.exception.CommandException;

public class CheckFuelCommand implements Command {

    private final Fuel fuel;
    private final int needFuel;

    public CheckFuelCommand(Fuel fuel, int needFuel) {
        this.fuel = fuel;
        this.needFuel = needFuel;
    }

    @Override
    public void execute() {
        if(fuel.getFuel()<needFuel)throw new CommandException("У вас недостаточно топлива");

    }
}
