package com.yunn.autumn.thread.threadenhance2.design.worker;

/**
 * Request
 *
 * @author yunN
 * @createTime 2021年01月22日 09:40
 * @description 具体的任务
 */
public class Request {

    private final String name;

    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }


    public void execute() {
        System.out.println(Thread.currentThread().getName() + this);
    }

    @Override
    public String toString() {
        return " Request => No. " + number + " Name. " + name;
    }

}
