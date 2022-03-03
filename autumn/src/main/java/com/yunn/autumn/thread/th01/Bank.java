package com.yunn.autumn.thread.th01;

/**
 * Bank
 *
 * @Author: Bff
 * @CreateTime: 2020-04-19
 * @Description: 运行叫票窗口的主类
 */
public class Bank {

    public static void main(String[] args) {
        /*
          模拟银行业务柜台,一个线程代表一个银行柜台
         */
        TicketWindow window01 = new TicketWindow("柜台01");
        // window01.start();

        final TicketWindowRunnable tic = new TicketWindowRunnable();
        Thread t1 = new Thread(tic, "柜台01");
        Thread t2 = new Thread(tic, "柜台02");
        Thread t3 = new Thread(tic, "柜台03");

        t1.start();
        t2.start();
        t3.start();

        Runnable r= ()-> System.out.println("run");
        r.run();

    }
}
