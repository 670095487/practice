package com.yunn.autumn.thread.threadenhance2.design.worker;

import java.util.Random;

/**
 * TransportThread
 *
 * @author yunN
 * @createTime 2021年01月22日 11:32
 * @description 创建任务，并将任务放至传送带 生产者
 */
public class TransportThread extends Thread {

    private final Channel channel;

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public TransportThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int cycle = 0; true; cycle++) {
                Request request = new Request(getName(), cycle);
                this.channel.put(request);
                Thread.sleep(RANDOM.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println("TransportThread sleep get a InterruptedException");
        }
    }
}

