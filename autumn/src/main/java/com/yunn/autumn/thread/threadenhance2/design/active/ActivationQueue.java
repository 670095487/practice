package com.yunn.autumn.thread.threadenhance2.design.active;

import java.util.LinkedList;

/**
 * ActivationQueue
 *
 * @author yunN
 * @createTime 2021年01月22日 18:58
 * @description 操作任务队列【存取任务】
 */
public class ActivationQueue {

    //队列最大任务数
    private final static int MAX_METHOD_REQUEST_SIZE = 100;

    //任务队列
    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        this.methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request) {
        while (methodQueue.size() >= MAX_METHOD_REQUEST_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        this.methodQueue.addLast(request);
        this.notifyAll();
    }

    public synchronized MethodRequest take() {
        //如果用if 那么会在判断一次以后就不会再判断了，但是在被其他线程唤醒以后，由于线程之间存在竞争关系，队列里的
        //任务很可能已经被其他线程取走了，这时候如果继续往下，会出现问题
        //这样的话，下次条件不满足的时候，这个wait()住的线程被唤醒后不会再次判断条件是否满足
        while (methodQueue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        MethodRequest methodRequest = this.methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}
