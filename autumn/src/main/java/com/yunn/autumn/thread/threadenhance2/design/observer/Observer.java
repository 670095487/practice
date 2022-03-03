package com.yunn.autumn.thread.threadenhance2.design.observer;

/**
 * Observer
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 观察者模式
 */
public abstract class Observer {


    protected Subject subject;

    /**
     * 通知方法，具体实现看子类
     * 2021年1月13日11:29:46
     */
    public abstract void update();

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
}
