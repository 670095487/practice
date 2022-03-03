package com.yunn.autumn.thread.th04;

/**
 * ThreadService
 *
 * @Author: Bff
 * @CreateTime: 2020-05-02
 * @Description:
 */
@SuppressWarnings("all")
public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;


    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            //假设这个线程处理的任务要花费很长时间
           /* while (true) {

            }*/
            /*
            模拟场景：假设这个线程实际执行这个任务只需要5s，那么该线程并不会等10s后才结束，
            而是在线程结束后就立即结束，这个属于正常结束任务的范畴，所以并不会触发任务超时
            被迫关闭。。。
             */
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*
         * 十秒后调用关闭线程的方法，也就是说每个线程执行任务的时间都是10s
         */
        threadService.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public void execute(Runnable target) {
        /*
        为executeThread线程定义一个守护线程
         */
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(target);
                runner.setDaemon(true);

                /*
                需要先开启守护线程，再开启执行线程，否则会报错
                 */
                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时，需要强制结束！");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
        finished = false;
    }
}
