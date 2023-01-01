package com.yunn.autumn.designpatterns.observe;

/**
 * @date 2022/12/21
 */
public class EventListener {

    private final String priority;

    public EventListener(String priority) {
        this.priority = priority;
    }

    public void update(String eventType, String name) {
        System.out.println("Current handle name is " + name + " , and it's priority is " + priority
                + " ,eventTyp is " + eventType);
    }

}
