package com.chubanova;

import com.chubanova.changevelocity.ChangeVelocityAble;
import com.chubanova.changevelocity.ChangeVelocityAdapter;
import com.chubanova.changevelocity.ChangeVelocityCommand;
import com.chubanova.fuel.BurnFuelCommand;
import com.chubanova.fuel.Fuel;
import com.chubanova.fuel.FuelAdapter;
import com.chubanova.ioc.*;
import com.chubanova.move.Vector;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class IoCTest {

    @BeforeAll
    public static void setUp(){
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        Initializer<ScopeDictionary<IoCDictionary>> initializerScopeDictionary = new InitializerScopeDictionary();
        initializerScopeDictionary.initialize(scopesDictionary);
    }
    @Test
    public void changeVelocityIoCTest(){
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        Initializer<ScopeDictionary<IoCDictionary>> initializerScopeDictionary = new InitializerScopeDictionary();
        initializerScopeDictionary.initialize(scopesDictionary);


        IoC.<Command>resolve("IoC.Register",
                new Object[]{"starShip",
                        (Function<Object[], Object>) ((args) -> {
                            UObject starShip = new StarShip();
                            starShip.setProperty("Direction", 1);
                            starShip.setProperty("DirectionsNumber", 3);
                            starShip.setProperty("Velocity", new Vector(100,0));
                            return starShip;
                        })}).execute();
        IoC.<Command>resolve("IoC.Register",
                        new Object[]{"changeVelocityAble",
                                (Function<Object[], Object>) ((args) -> new ChangeVelocityAdapter((UObject) args[0]))})
                .execute();
        IoC.<Command>resolve("IoC.Register",
                new Object[]{ "changeVelocityCommand",
                        (Function<Object[], Object>) ((args) -> new ChangeVelocityCommand((ChangeVelocityAble) args[0]))}
        ).execute();

        StarShip starShip = IoC.resolve("starShip", new Object[]{});
        ChangeVelocityAdapter adapter = IoC.resolve("changeVelocityAble", new Object[]{starShip});
        Command command = IoC.resolve("changeVelocityCommand", new Object[]{adapter});
        command.execute();



        Vector v = (Vector) starShip.getProperty("Velocity");
        assertEquals(-49.0, v.getX(),0.0);
        assertEquals(86.0, v.getY(),0.0);

    }

    @Test
    public void burnFuelIoCTest(){
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        Initializer<ScopeDictionary<IoCDictionary>> initializerScopeDictionary = new InitializerScopeDictionary();
        initializerScopeDictionary.initialize(scopesDictionary);

        IoC.<Command>resolve("IoC.Register",
                new Object[]{"starShip",
                        (Function<Object[], Object>) ((args) -> {
                            UObject starShip = new StarShip();
                            starShip.setProperty("Fuel", 10);

                            return starShip;
                        })}).execute();
        IoC.<Command>resolve("IoC.Register",
                        new Object[]{"fuelAdapter",
                                (Function<Object[], Object>) ((args) -> new FuelAdapter((UObject) args[0]))})
                .execute();
        IoC.<Command>resolve("IoC.Register",
                new Object[]{ "burnFuelCommand",
                        (Function<Object[], Object>) ((args) -> new BurnFuelCommand((Fuel) args[0], (Integer) args[1]))}
        ).execute();

        StarShip starShip = IoC.resolve("starShip", new Object[]{});
        FuelAdapter adapter = IoC.resolve("fuelAdapter", new Object[]{starShip});
        Command command = IoC.resolve("burnFuelCommand", new Object[]{adapter,10});
        command.execute();


        assertEquals(0, adapter.getFuel());


    }


    @Test
    public void changeVelocityIoCTest_2(){
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        Initializer<ScopeDictionary<IoCDictionary>> initializerScopeDictionary = new InitializerScopeDictionary();
        initializerScopeDictionary.initialize(scopesDictionary);

        IoC.<Command>resolve("Scopes.New", new Object[]{"ScopeChangeVelocity"}).execute();

        IoC.<Command>resolve("IoC.Register",
                new Object[]{"starShip",
                        (Function<Object[], Object>) ((args) -> {
                            UObject starShip = new StarShip();
                            starShip.setProperty("Direction", 1);
                            starShip.setProperty("DirectionsNumber", 3);
                            starShip.setProperty("Velocity", new Vector(100,0));
                            return starShip;
                        })}).execute();
        IoC.<Command>resolve("IoC.Register",
                        new Object[]{"changeVelocityAble",
                                (Function<Object[], Object>) ((args) -> new ChangeVelocityAdapter((UObject) args[0]))})
                .execute();
        IoC.<Command>resolve("IoC.Register",
                new Object[]{ "changeVelocityCommand",
                        (Function<Object[], Object>) ((args) -> new ChangeVelocityCommand((ChangeVelocityAble) args[0]))}
        ).execute();


        IoC.<Command>resolve("Scopes.New", new Object[]{"ScopeBurnFuel"}).execute();
        IoC.<Command>resolve("IoC.Register",
                new Object[]{"starShip",
                        (Function<Object[], Object>) ((args) -> {
                            UObject starShip = new StarShip();
                            starShip.setProperty("Fuel", 10);

                            return starShip;
                        })}).execute();
        IoC.<Command>resolve("IoC.Register",
                        new Object[]{"fuelAdapter",
                                (Function<Object[], Object>) ((args) -> new FuelAdapter((UObject) args[0]))})
                .execute();
        IoC.<Command>resolve("IoC.Register",
                new Object[]{ "burnFuelCommand",
                        (Function<Object[], Object>) ((args) -> new BurnFuelCommand((Fuel) args[0], (Integer) args[1]))}
        ).execute();


        IoC.<Command>resolve("Scopes.Current", new Object[]{"ScopeChangeVelocity"}).execute();
        StarShip starShip = IoC.resolve("starShip", new Object[]{});
        IoC.<Command>resolve("Scopes.Current", new Object[]{"ScopeBurnFuel"}).execute();
        StarShip starShip2 = IoC.resolve("starShip", new Object[]{});


        Vector v = (Vector) starShip.getProperty("Velocity");
        assertEquals(100, v.getX(),0.0);
        assertEquals(0, v.getY(),0.0);
        assertEquals(10,starShip2.getProperty("Fuel"));

    }

}
