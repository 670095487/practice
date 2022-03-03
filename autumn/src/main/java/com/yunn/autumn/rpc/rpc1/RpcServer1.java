package com.yunn.autumn.rpc.rpc1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yunN on 2021/06/04.
 */
public class RpcServer1 extends Thread {

    private ServerSocket serverSocket;

    public RpcServer1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(1000000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort()
                        + "...");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());//读客户端发送过来的信息
                DataOutputStream out = new DataOutputStream(server.getOutputStream());//往客户端发信息
                out.writeUTF("thanks :" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        // int port = Integer.parseInt(args[0]);
        try {
            Thread rpcServer1 = new RpcServer1(6066);
            rpcServer1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
