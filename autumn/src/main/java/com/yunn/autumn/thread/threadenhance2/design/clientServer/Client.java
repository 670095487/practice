package com.yunn.autumn.thread.threadenhance2.design.clientServer;

import java.io.IOException;

/**
 * Client
 *
 * @author: yunN
 * @createTime: 2021/01/18 17:41:46
 * @description: 模拟应用服务器客户端
 */
public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {
        ServerApplication serverApplication = new ServerApplication(12245);
        serverApplication.start();

        Thread.sleep(25_000L);

        serverApplication.shutdown();
    }
}
