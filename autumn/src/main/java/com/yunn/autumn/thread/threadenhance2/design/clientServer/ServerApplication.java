package com.yunn.autumn.thread.threadenhance2.design.clientServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ServerApplication
 *
 * @author: yunN
 * @createTime: 2021/01/18 17:42:54
 * @description:
 */
@SuppressWarnings("all")
public class ServerApplication extends Thread {

    private final int port;

    private static final int DEFAULT_PORT = 12172;

    private volatile boolean start = true;

    private final List<ClientHandler> clientHandlers = new ArrayList<>();

    private ServerSocket serverSocket;

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public ServerApplication() {
        this(DEFAULT_PORT);
    }

    public ServerApplication(int port) {
        this.port = port;
    }


    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(port);
            while (start) {
                System.out.println("server is running ...");
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                executor.submit(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //最终会主动释放自身的连接
            this.dispose();
        }
    }

    /**
     * 销毁本地连接
     */
    private void dispose() {
        //逐个关闭所有的客户端连接
        this.clientHandlers.stream().forEach(ClientHandler::stop);
        //关闭线程池
        this.executor.shutdown();
    }

    /**
     * 服务器端的关闭
     * @throws /
     */
    public void shutdown() throws IOException {
        //可运行标志置为false
        this.start = false;
        //中断当前线程
        this.interrupt();
        //关闭socket监听
        this.serverSocket.close();
    }
}
