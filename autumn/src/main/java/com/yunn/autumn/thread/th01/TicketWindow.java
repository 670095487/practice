package com.yunn.autumn.thread.th01;

/**
 * TictetWindow
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 多线程模拟银行叫票窗口
 */
public class TicketWindow extends Thread {

    /**
     * 定义柜台名称变量
     */
    private String name;
    /**
     * 定义总票数
     */
    private final int MAX = 50;
    /**
     * 定义初始票数，从1开始
     */
    private int index = 1;

    /**
     * 初始化有参构造，在生成柜台时指定名称
     *
     * @param name
     */
    public TicketWindow(String name) {
        this.name = name;
    }

    /**
     * 叫票主体逻辑
     */
    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("当前柜台名称为：" + name + "，当前号码是：" + index++);
        }
    }
}
