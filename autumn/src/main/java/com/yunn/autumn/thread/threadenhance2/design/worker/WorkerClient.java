package com.yunn.autumn.thread.threadenhance2.design.worker;

/**
 * WorkerClient
 *
 * @author yunN
 * @createTime 2021年01月22日 12:38
 * @description
 */
public class WorkerClient {

    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();
        new TransportThread("yunN",channel).start();
        new TransportThread("xxx",channel).start();
        new TransportThread("bbb",channel).start();
    }
}
