package com.chubanova;

import java.util.HashMap;
import java.util.Map;

public class StarShip implements UObject {

    private final Map<String, Object> properties = new HashMap<>();

    @Override
    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public void setProperty(String propertyName, Object property) {
        properties.put(propertyName, property);
    }
}
