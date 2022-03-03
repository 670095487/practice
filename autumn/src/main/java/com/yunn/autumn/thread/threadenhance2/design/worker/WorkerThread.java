package com.yunn.autumn.thread.threadenhance2.design.worker;

import java.util.Random;

/**
 * WorkerThread
 *
 * @author yunN
 * @createTime 2021年01月22日 09:41
 * @description 工人线程 : 负责从任务流水线上取任务执行 消费者
 */
public class WorkerThread extends Thread {

    private final Channel channel;

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            channel.take().execute();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
