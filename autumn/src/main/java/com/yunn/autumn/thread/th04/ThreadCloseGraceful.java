package com.yunn.autumn.thread.th04;

/**
 * ThreadCloseGraceful
 *
 * @Author: Bff
 * @CreateTime: 2020-05-02
 * @Description:
 */
public class ThreadCloseGraceful {

    private static class Worker extends Thread {
        int i = 0;

        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("break;");
                    return;
                }
               /* System.out.println("次数"+(++i)+"，当前正在运行的线程名称："+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
