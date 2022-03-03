package com.yunn.autumn.thread.threadenhance2.design.observer;

/**
 * ObserverClient
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description:
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        //通知
        subject.setState(10);
        //虽然调用了set()但是主体的状态和上次一样，无需再次通知观察者们
        subject.setState(10);
        //通知
        subject.setState(15);
    }
}
