package com.chubanova.fuel;

import com.chubanova.UObject;

public class FuelAdapter implements Fuel{

    UObject o;
    public FuelAdapter(UObject o) {
        this.o = o;
    }
    @Override
    public int getFuel() {
        return (int) o.getProperty("Fuel");
    }

    @Override
    public void setFuel(int fuel) {
        o.setProperty("Fuel", fuel);
    }
}
