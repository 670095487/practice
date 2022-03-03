package com.yunn.autumn.thread.interrupt;

/**
 * JoinStudy
 *
 * @author: yunN
 * @createTime: 2020/12/30
 * @description:
 */
public class JoinStudy {

    public static void main(String[] args) {

        MyThread mt1 = new MyThread("子线程1");
        MyThread mt2 = new MyThread("子线程2");

        mt1.start();
        mt2.start();
        try {
            //子线程join main线程，子线程先启动完成，main才会去做自己的逻辑
            mt1.join();//其他线程会等待调用join()的线程执行完成以后再执行
            mt2.join();
        } catch (InterruptedException e) {
            System.out.println("~");
        }
        for (int i = 0; i <= 20; i++) {
            System.out.println("主线程:" + i);
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}
