package com.yunn.autumn.thread.threadenhance2.design.observer;

/**
 * BinaryObserver
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description:
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    /**
     * 通知内容
     */
    @Override
    public void update() {
        System.out.println("BinaryObserver:" + Integer.toBinaryString(subject.getState()));
    }
}
