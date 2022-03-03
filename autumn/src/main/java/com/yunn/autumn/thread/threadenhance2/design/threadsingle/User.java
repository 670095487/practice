package com.yunn.autumn.thread.threadenhance2.design.threadsingle;

/**
 * User
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 想要进门的线程
 */
public class User extends Thread {

    private final String myName;

    private final String myAddress;

    private final Gate gate;


    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + "BEGIN");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}
