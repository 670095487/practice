package com.yunn.autumn.designpatterns.observe;

/**
 * @date 2022/12/21
 */
public class App {

    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.subscribe("x", new EventListener("1"));
        eventManager.subscribe("b", new EventListener("2"));
        eventManager.subscribe("d", new EventListener("3"));
        eventManager.notify("x","x-name");
        eventManager.unsubscribe("x", new EventListener("1"));
    }
}
