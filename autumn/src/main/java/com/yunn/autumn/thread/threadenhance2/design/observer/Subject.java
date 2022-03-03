package com.yunn.autumn.thread.threadenhance2.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description:
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    /**
     * 改变一次就通知一次所有观察者
     * @param state 被观察的主体
     */
    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    /**
     * 添加所有需要观察此主体的观察者
     * @param observer /
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 调用所有观察者自己的通知方法
     * 在主体状态改变后，调用各自自己的通知方法，各自决定在主体发生改变以后自己应该做什么
     */
    private void notifyAllObserver() {
        observers.forEach(Observer::update);
    }




}
