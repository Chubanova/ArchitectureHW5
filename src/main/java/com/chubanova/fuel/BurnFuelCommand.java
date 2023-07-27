package com.chubanova.fuel;

import com.chubanova.Command;

public class BurnFuelCommand implements Command {
    private final Fuel fuel;
    private final int needFuel;

    public BurnFuelCommand(Fuel fuel, int needFuel) {
        this.fuel = fuel;
        this.needFuel = needFuel;
    }

    @Override
    public void execute() {
        fuel.setFuel(fuel.getFuel()-needFuel);

    }
}
