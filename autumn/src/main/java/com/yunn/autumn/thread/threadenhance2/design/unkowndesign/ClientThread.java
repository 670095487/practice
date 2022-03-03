package com.yunn.autumn.thread.threadenhance2.design.unkowndesign;

import java.util.Random;

/**
 * ClientThread
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description: 模拟客户端
 */
public class ClientThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
        this.sendValue = sendValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Client ->" + sendValue);
            queue.putRequest(new Request(sendValue));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {
                System.out.println("ClientThread sleep throw an exception~");
            }
        }
        //给个标志 代表客户端已经结束
        queue.putRequest(null);
    }
}
