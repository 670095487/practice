package com.yunn.autumn.thread.th01;

/**
 * TicketWindowRunnable
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 使用实现接口的方式来创建线程
 */
public class TicketWindowRunnable implements Runnable {

    private final static int MAX = 50;

    private int index = 1;

    /**
     * 线程的主体逻辑
     */
    public void run() {
        while (index <= MAX) {
            System.out.println("当前柜台名称为：" + Thread.currentThread().getName() + "，当前号码是：" + index++);
        }
    }
}
