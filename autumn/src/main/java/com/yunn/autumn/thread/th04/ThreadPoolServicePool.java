package com.yunn.autumn.thread.th04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ThreadPoolService
 *
 * @Author: Bff
 * @CreateTime: 2020-04-26
 * @Description: 自定义一个线程池
 */
@SuppressWarnings("all")
public class ThreadPoolServicePool {

    /**
     * 线程池大小
     */
    private int size;
    /**
     * 线程池默认大小
     */
    private final static int DEFAULT_SIZE = 10;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();


    public ThreadPoolServicePool() {
    }


    public ThreadPoolServicePool(int size) {
        this.size = size;
        init();
    }

    /**
     * 初始化线程池的时候调用的方法
     */
    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    /**
     * 提交任务至任务队列
     *
     * @param runnable
     */
    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.add(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    /**
     * 创建任务的方法
     */
    public void createWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
            /*
            将创建好的任务添加到队列中
             */
        THREAD_QUEUE.add(task);
    }

    /**
     * 定义线程状态的枚举，见名知义
     */
    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    /**
     * 定义了线程池中的线程的生命周期以及需要实现的任务
     */
    private static class WorkerTask extends Thread {
        public volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);

        }

        /**
         * 从线程池中取出一个线程
         *
         * @return
         */
        public TaskState getTaskState() {
            return this.taskState;
        }

        /**
         * 线程执行任务的基本逻辑
         */
        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    /*
                        移除线程队列中的第一个线程，此时他已完成任务
                     */
                    runnable = TASK_QUEUE.removeFirst();
                    if (runnable != null) {
                        taskState = TaskState.RUNNING;
                        runnable.run();
                        taskState = TaskState.FREE;
                    }
                }
            }
        }

        /**
         * 当线程执行完任务后关闭线程
         */
        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) {
        ThreadPoolServicePool tPool = new ThreadPoolServicePool();
        /*
        rangeClosed(a,b)	返回子序列 [a,b)，左闭又开。意味着包括 b 元素，增长步值为 1
        range(a,b)	        返回子序列 [a,b)，左闭右开，意味着不包括 b
        这里后面forEach中使用的i就是 a < i <=40
        对应普通写法：
        for (int i = 0; i < 41; i++) {
            tPool.submit();
        }
         */
        IntStream.rangeClosed(0, 40)
                .forEach(i ->
                        tPool.submit(() -> {
                            System.out.println("The runnable " + i + "be serviced by" + Thread.currentThread().getName());
                            try {
                                Thread.sleep(100000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("The runnable " + i + "be done by" + Thread.currentThread().getName());
                        }));
    }
}
