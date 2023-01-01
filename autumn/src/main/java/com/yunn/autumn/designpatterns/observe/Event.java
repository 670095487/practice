package com.yunn.autumn.designpatterns.observe;

/**
 * @date 2022/12/21
 */
public class Event {

    private final String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
