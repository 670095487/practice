package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * SchedulerThread
 *
 * @author yunN
 * @createTime 2021年01月22日 20:00
 * @description
 */
public class SchedulerThread extends Thread{

    private final ActivationQueue activationQueue;

    /**
     * 初始化需要操作的任务队列
     * @param activationQueue /
     */
    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    /**
     * 将请求存入队列
     * @param request /
     */
    public void invoke(MethodRequest request) {
        this.activationQueue.put(request);
    }

    /**
     * 循环从队列中取任务
     */
    @Override
    public void run() {
        while (true) {
            activationQueue.take().execute();
        }
    }
}
