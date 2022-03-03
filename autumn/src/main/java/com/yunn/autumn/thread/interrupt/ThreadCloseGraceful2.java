package com.yunn.autumn.thread.interrupt;

/**
 * ThreadCloseGraceful
 *
 * @author: yunN
 * @createTime: 2020/12/28
 * @description:
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {
        private volatile boolean start = true;

        @Override
        public void run() {
            /*while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }*/
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
            }
            //即使线程被打断此处的逻辑还是可以执行的
            System.out.println("logic");
        }

        public void shutdown() {
            this.start = false;
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
