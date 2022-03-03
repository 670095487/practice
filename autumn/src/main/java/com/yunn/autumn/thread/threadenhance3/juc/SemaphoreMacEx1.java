package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreMacEx1
 *
 * @author yunN
 * @createTime 2021年02月02日 10:02
 * @description
 */
public class SemaphoreMacEx1 {


    public static void main(String[] args) {
        //许可证1
       final Semaphore semaphore = new Semaphore(1);

       // new Thread(()->{
       //     try {
       //         semaphore.acquire();
       //         System.out.println("get semaphore success");
       //         TimeUnit.SECONDS.sleep(10);
       //         System.out.println("release semaphore success");
       //     } catch (InterruptedException e) {
       //         // e.printStackTrace();
       //     }finally {
       //         semaphore.release();
       //     }
       // }).start();
       //
       //  new Thread(()->{
       //      try {
       //          semaphore.acquire();
       //          System.out.println("get semaphore success");
       //          TimeUnit.SECONDS.sleep(10);
       //          System.out.println("release semaphore success");
       //      } catch (InterruptedException e) {
       //          // e.printStackTrace();
       //      }finally {
       //          semaphore.release();
       //      }
       //  }).start();

        new Thread(()->{
            //一次获取所有许可证。
            // semaphore.drainPermits()
        }).start();
    }
}
