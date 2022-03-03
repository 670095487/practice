package com.yunn.autumn.thread.不可变类;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2021/11/21.
 */
public class CarLocationTracker {

    private static volatile CarLocationTracker tracker = new CarLocationTracker();

    private final Map<String, Location> locationMap = new HashMap<>();

    public Location updateLocation(String key, Location location) {
        locationMap.put(key, location);
        return location;
    }

    public Location getLocation(String key) {
        return locationMap.get(key);
    }

    public void setInstance(CarLocationTracker instance) {
        tracker = instance;
    }
}
