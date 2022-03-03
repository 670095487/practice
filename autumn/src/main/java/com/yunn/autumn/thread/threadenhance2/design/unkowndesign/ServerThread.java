package com.yunn.autumn.thread.threadenhance2.design.unkowndesign;

import java.util.Random;

/**
 * ServerThread
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description: 模拟服务器
 */
public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!flag) {
            Request request = queue.getRequest();
            //服务器端接收到了一个空的请求，说明客户端已经停止请求，可以关闭服务器端了
            if (request == null) {
                System.out.println("get a empty request......");
                break;
            }
            System.out.println("Server ->" + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
        close();
    }

    /**
     * 关闭服务端
     */
    public void close() {
        this.flag = true;
        this.interrupt();
    }
}
