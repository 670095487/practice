package com.yunn.autumn.thread.th06;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * VolatileApplication
 *
 * @Author: Bff
 * @CreateTime: 2020-06-20
 * @Description: 不使用此关键字和使用此关键字的区别
 */
public class VolatileApplication {


    /**
     * 定义一个共享变量
     */
    public int data = 0;

    /**
     * 显示初始化两个线程
     */
    @Test
    public void main() {


        new Thread() {
            @Override
            public void run() {
                data++;
                System.out.println("data被改变,值=" + data + "时间为=" + System.currentTimeMillis());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (data == 0) {
                    try {
                        System.out.println("data = " + data + ",时间=" + System.currentTimeMillis());
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    /**
     * 使用线程池创建线程
     */
    @Test
    public void threadPoolTest() {
        ThreadFactoryBuilder demoThread = (ThreadFactoryBuilder) new ThreadFactoryBuilder()
                .setNamePrefix("demo-%d").build();
        /*
          线程池拒绝策略如下:
           1. CallerRunsPolicy ：这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。

           2. AbortPolicy ：对拒绝任务抛弃处理，并且抛出异常。

           3. DiscardPolicy ：对拒绝任务直接无声抛弃，没有异常信息。

           4. DiscardOldestPolicy ：对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列。
         */
        ThreadPoolExecutor singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), (ThreadFactory) demoThread, new ThreadPoolExecutor.AbortPolicy());
    }
}
