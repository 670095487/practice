package com.yunn.autumn.designpatterns.observe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2022/12/21
 */
public class EventManager {

    // eventType-listeners
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... eventType) {
        for (String et : eventType) {
            listeners.put(et, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(eventListener);
    }

    public void unsubscribe(String eventType, EventListener eventListener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(eventListener);
    }

    public void notify(String eventType, String name) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener eventListener : users) {
            eventListener.update(eventType ,name);
        }
    }


}
