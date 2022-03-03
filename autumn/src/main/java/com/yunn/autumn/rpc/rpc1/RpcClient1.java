package com.yunn.autumn.rpc.rpc1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yunN on 2021/06/04.
 */
public class RpcClient1 {

    public static void main(String[] args) throws Exception {
        String serverName = "127.0.0.1";
        int port = 6066;
        System.out.println("连接到主机：" + serverName + ",端口号：" + port);
        Socket client = new Socket(serverName, port);
        System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
        OutputStream outToServer = client.getOutputStream();//往外写消息
        DataOutputStream out = new DataOutputStream(outToServer);//装饰者，加强流

        out.writeUTF("Hello from " + client.getLocalSocketAddress());
        InputStream inFromServer = client.getInputStream();//从外读消息到ram
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println("服务器响应 ： " + in.readUTF());
        client.close();
    }
}
