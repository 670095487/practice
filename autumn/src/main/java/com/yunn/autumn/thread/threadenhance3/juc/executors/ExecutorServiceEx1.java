package com.yunn.autumn.thread.threadenhance3.juc.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ExecutorServiceEx1
 *
 * @author yunN
 * @createTime 2021年02月05日 10:46
 * @description
 */
public class ExecutorServiceEx1 {


    public static void main(String[] args) {
        testIsShutDown();
    }

    private static void testIsShutDown() {
        //始终只有一个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //false
        System.out.println(executorService.isShutdown());
        //销毁线程池
        executorService.shutdown();

        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //true
        System.out.println(executorService.isShutdown());

    }

    private abstract static class MyTask implements Runnable {

        protected final int no;

        private MyTask(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                this.doInit();
                this.doExecute();
                this.done();
            } catch (Throwable cause) {
                this.error(cause);
            }
        }

        protected abstract void error(Throwable cause);

        protected abstract void done();

        protected abstract void doExecute();

        protected abstract void doInit();
    }

    /**
     * 在执行任务时可以按照自定义的步骤去触发提醒，更加友好
     *
     * @throws InterruptedException /
     */
    private static void executeRunnableError() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i -> {
            executorService.execute(new MyTask(i) {
                /**
                 * 若出错，打印错误原因
                 * @param cause /
                 */
                @Override
                protected void error(Throwable cause) {

                }

                /**
                 * 任务正常结束
                 */
                @Override
                protected void done() {

                }

                /**
                 * 任务本身
                 */
                @Override
                protected void doExecute() {

                }

                /**
                 * 任务初始化 赋值...
                 */
                @Override
                protected void doInit() {

                }

            });
        });

    }
}
