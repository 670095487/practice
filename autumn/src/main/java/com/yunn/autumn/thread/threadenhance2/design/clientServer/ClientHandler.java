package com.yunn.autumn.thread.threadenhance2.design.clientServer;

import java.io.*;
import java.net.Socket;

/**
 * ClientHandler
 *
 * @author: yunN
 * @createTime: 2021/01/18 18:02:19
 * @description: 处理客户端连接
 */
public class ClientHandler implements Runnable {

    public final Socket client;

    /**
     * 容器是否还是运行态
     */
    private volatile boolean running = true;


    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStream inputStream = client.getInputStream();
             OutputStream outputStream = client.getOutputStream();
             //装饰者模式
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream)) {
            while (running) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("get a msg from client ->" + message);
                printWriter.write("echo " + message);
                printWriter.flush();
            }
        } catch (IOException e) {
            this.running = false;
        }
    }

    public void stop() {
        //判断容器是否在运行态，运行态，此方法不做任何操作，非运行态，此方法主动关闭服务端
        if (!running) {
            return;
        }
        this.running = true;
        try {
            //关闭客户端
            this.client.close();
        } catch (IOException e) {
            System.out.printf("socket close fail,cause: {%s} \n", e);
        }
    }
}
