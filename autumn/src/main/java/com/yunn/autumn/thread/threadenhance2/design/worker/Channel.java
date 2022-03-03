package com.yunn.autumn.thread.threadenhance2.design.worker;

import java.util.Arrays;

/**
 * Channel
 *
 * @author: yunN
 * @createTime: 2021/01/19 14:05:50
 * @description: 传送带 - 可以类比为一个消息队列。
 */
public class Channel {

    private final static int MAX_REQUEST = 100;

    private final Request[] requestQueue;

    private int head;

    private int tail;

    private int count;

    private final WorkerThread[] workerPool;

    public Channel(int works) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.workerPool = new WorkerThread[works];
        this.init();
    }

    /**
     * 初始化工作者线程。
     */
    private void init() {
        for (int i = 0; i < workerPool.length; i++) {
            workerPool[i] = new WorkerThread("worker-" + i, this);
        }
    }

    public void startWorker() {
        Arrays.asList(workerPool).forEach(WorkerThread::start);
    }

    /**
     * 向队列中放请求
     *
     * @param request /
     */
    public synchronized void put(Request request) {
        //现在请求的数量是否已经大于队列的最大容量
        while (count >= requestQueue.length) {
            try {
                this.wait();
            } catch (Exception e) {
                //
            }
        }
        /*
            1.头插法 ？
         */
        this.requestQueue[tail] = request;
        this.tail = (tail + 1) % this.requestQueue.length;
        this.count++;
        this.notifyAll();
    }

    /**
     * 从队列中取请求
     *
     * @return /
     */
    public synchronized Request take() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = this.requestQueue[head];
        /*
            1。从头开始取，策略：FIFO
         */
        this.head = (this.head + 1) % this.requestQueue.length;
        this.count--;
        this.notifyAll();
        return request;
    }
}
