package com.yunn.autumn.thread.threadpool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * SimpleThreadPool
 *
 * @author: yunN
 * @createTime: 2021/01/05
 * @description: 简单线程池实现
 */
public class SimpleThreadPool extends Thread {
    /*
     * 基本概念
     * 1.任务队列
     * 2.拒绝策略【抛出异常，直接丢弃，阻塞新增任务，放置临时队列】
     * 3.init大小（min）
     * 4.active 线程活跃数
     * 5.max最大线程数
     *
     * 线程池内线程数变化规律：min>=active>=max
     * */

    public int size;

    public final int queueSize;

    private final static int DEFAULT_SIZE = 10;
    /**
     * 任务集合，FIFO
     */
    private final static LinkedList<Runnable> TASK_QUEEN = new LinkedList<>();

    private final static String THREAD_PREFIX = "Simple_Thread_Pool-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");
    /**
     * 线程序列号，从0开始，自增策略
     */
    private static volatile int seq = 0;

    /**
     * 线程集合，FIFO ? todo 这个集合起到了什么作用？就只是存放新启动的线程吗
     */
    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    /**
     * 默认任务队列最大承受任务数
     */
    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

    /**
     * 拒绝策略接口
     */
    private final DiscardPolicy discardPolicy;

    /**
     * 定义默认拒绝策略
     * <p>
     * discard : 丢弃; 抛弃;
     * Policy : 策略
     */
    private final static DiscardPolicy DISCARD_POLICY = () -> {
        throw new DiscardException("discard this task...");
    };

    /**
     * 当前线程池状态是否为 已销毁
     */
    private volatile boolean destroy = false;

    private final static int DEFAULT_MIN = 4;
    private final static int DEFAULT_ACTIVE = 8;
    private final static int DEFAULT_MAX = 12;
    /**
     * 线程池最小线程数
     */
    private final int min;

    /**
     * 线程池活跃线程数
     */
    private final int active;

    /**
     * 线程池最大线程数
     */
    private final int max;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 构造函数
     * 指定池内线程数、任务队列数目、拒绝策略
     *
     * @param min           /
     * @param active        /
     * @param max           /
     * @param queueSize     /
     * @param discardPolicy /
     */
    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isDestroy() {
        return this.destroy;
    }

    public int getMin() {
        return min;
    }

    public int getActive() {
        return active;
    }

    public int getMax() {
        return max;
    }

    /**
     * 线程池无参构造，若调用者不指定线程池所需属性
     * 就使用默认属性 ：线程池大小、任务队列大小、线程池拒绝策略
     */
    public SimpleThreadPool() {
        this(DEFAULT_MIN, DEFAULT_ACTIVE, DEFAULT_MAX, DEFAULT_TASK_QUEUE_SIZE, DISCARD_POLICY);
    }

    /**
     * 创建指定数量线程
     */
    private void init() {
        for (int i = 0; i < this.min; i++) {
            createWorkTask();
        }
        this.size = min;
        this.start();
    }

    /**
     *
     */
    private void createWorkTask() {
        //创建任务线程
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        //将当前任务线程添加至线程队列
        THREAD_QUEUE.add(task);
    }

    public void shutdown() throws InterruptedException {
        while (!TASK_QUEEN.isEmpty()) {
            Thread.sleep(50);
        }
        //统计线程总数
        synchronized (THREAD_QUEUE) {
            int initVal = THREAD_QUEUE.size();
            while (initVal > 0) {
                //逐个销毁线程
                for (WorkerTask task : THREAD_QUEUE) {
                    if (task.getTaskState() == TaskState.BLOCKED) {
                        task.interrupt();
                        task.close();
                        initVal--;
                    } else {
                        Thread.sleep(10);
                    }
                }
            }

        }
        //将线程池状态置为已销毁
        this.destroy = true;
        System.out.println("线程池已销毁...");
    }


    /**
     * 线程池'自己'的线程，监控'自己'
     */
    @Override
    public void run() {
        while (!destroy) {
            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d \n",
                    this.min, this.active, this.max, this.size, TASK_QUEEN.size());
            try {
                Thread.sleep(5_000L);
                //当前任务队列大于活跃线程数 且 当前线程数小于活跃线程数
                if (TASK_QUEEN.size() > active && size < active) {
                    //将当前线程数从min扩充至active
                    for (int i = size; i < active; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented ++++++++++++");
                    size = active;
                    //当前任务队列大于最大线程数 且 当前线程数小于最大线程数
                } else if (TASK_QUEEN.size() > max && size < max) {
                    //将当前线程数从active扩充至max
                    for (int i = size; i < active; i++) {
                        createWorkTask();
                    }
                    System.out.println("The pool incremented ++++++++++++");
                    size = max;
                }

                //如果当前任务队列为空 且 当前线程池线程数 大于 活跃数 ，就将线程池内的线程数减少至活跃数，保持线程池内有活跃数目的线程
                synchronized (THREAD_QUEUE) {
                    if (TASK_QUEEN.isEmpty() && size > active) {
                        System.out.println("reduce-------------------");
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> iterator = THREAD_QUEUE.iterator(); iterator.hasNext(); ) {
                            if (releaseSize <= 0) break;
                            WorkerTask task = iterator.next();
                            task.close();
                            task.interrupt();
                            iterator.remove();
                            releaseSize--;
                        }
                        size = active;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对外暴露添加任务
     *
     * @param runnable / 提交的任务为线程形式
     */
    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalArgumentException("线程池已销毁，提交任务非法");
        }
        //线程队列
        synchronized (TASK_QUEEN) {
            //如果此时任务队列中的任务已经比预设的任务队列最大值大，那么再次进来的任务就走指定的拒绝策略
            if (TASK_QUEEN.size() > queueSize) {
                discardPolicy.discard();
            }
            TASK_QUEEN.addLast(runnable);
            TASK_QUEEN.notifyAll();
        }
    }

    /**
     * 自定义异常
     */
    public static class DiscardException extends RuntimeException {

        private static final long serialVersionUID = 6688378445942271637L;

        public DiscardException(String message) {
            super(message);
        }
    }

    /**
     * 拒绝策略接口
     */
    public interface DiscardPolicy {

        void discard() throws DiscardException;
    }

    /**
     * 线程类，这个线程类里有具体的实现逻辑，也就是说这里预设的逻辑就是这个任务需要做的事情
     */
    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                //加锁是为了不让任务被重复执行，所以在拿到需要执行的任务后就可以释放锁了
                synchronized (TASK_QUEEN) {
                    while (TASK_QUEEN.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEEN.wait();
                        } catch (InterruptedException e) {
                            System.out.println("close()()()()()()()()()()");
                            break OUTER;
                        }
                    }
                    //取出任务队列中第一个任务 取出任务后立即释放锁资源，【尽可能保证持有锁的时间短】
                    runnable = TASK_QUEEN.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        // for (int i = 0; i < 40; i++) {
        //     simpleThreadPool.submit(() -> {
        //         System.out.printf("当前任务正在被[%s]线程执行", Thread.currentThread().getName());
        //         System.out.println();
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             // e.printStackTrace();
        //         }
        //         System.out.printf("当前任务已经被[%s]线程完成", Thread.currentThread().getName());
        //         System.out.println();
        //     });
        // }
        IntStream.rangeClosed(0, 40)
                .forEach(i ->   //i就是for循环里的index,从0~40
                        simpleThreadPool.submit(() -> {     //()代表Thread类型的参数，因为只有一个参数，故可以省略
                            System.out.println("已提交任务 " + i);
                            System.out.printf("当前任务[%s]正在被[%s]线程执行 \n", i, Thread.currentThread().getName());
                            System.out.println();
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                // e.printStackTrace();
                            }
                            System.out.printf("当前任务[%s]已经被[%s]线程完成 \n", i, Thread.currentThread().getName());
                            System.out.println();
                        }));
        Thread.sleep(20000);
        simpleThreadPool.shutdown();
        simpleThreadPool.submit(() -> {
            System.out.println("异常提交");
        });
    }
}
