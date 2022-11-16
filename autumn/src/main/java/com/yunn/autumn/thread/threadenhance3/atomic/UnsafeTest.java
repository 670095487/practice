// package com.yunn.autumn.thread.threadenhance3.atomic;
//
// import sun.misc.Unsafe;
//
// import java.lang.reflect.Field;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.TimeUnit;
// import java.util.concurrent.locks.ReentrantLock;
//
// /**
//  * UnsafeTest
//  *
//  * @author: yunN
//  * @createTime: 2021/01/29 16:23:24
//  * @description:
//  */
// public class UnsafeTest {
//
//
//     public static void main(String[] args) throws Exception {
//         ExecutorService pools = Executors.newFixedThreadPool(10000);
//         Counter counter = new CasCounter();
//         long start = System.currentTimeMillis();
//         for (int i = 0; i < 1000; i++) {
//             pools.submit(new CounterRunnable(counter, 10000));
//         }
//         pools.shutdown();
//         pools.awaitTermination(1, TimeUnit.HOURS);
//         long end = System.currentTimeMillis();
//
//         System.out.println("Counter result: " + counter.getCounter());
//         System.out.println("time = " + (end - start));
//     }
//
//     /**
//      * 通过反射拿到 unsafe
//      *
//      * @return /
//      */
//     private static Unsafe getUnsafe() {
//         try {
//             Field field = Unsafe.class.getDeclaredField("theUnsafe");
//             field.setAccessible(true);
//             return (Unsafe) field.get(null);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
//
//     /**
//      * 静态内部类模拟 无锁、sync、lock、atomic对应的效率
//      */
//     static class StupidedCounter implements Counter {
//
//         private final ReentrantLock lock = new ReentrantLock();
//
//         private long counter = 0;
//
//         @Override
//         public void increment() {
//
//             try {
//                 lock.lock();
//                 counter++;
//             } finally {
//                 lock.unlock();
//             }
//         }
//
//         @Override
//         public long getCounter() {
//             return counter;
//         }
//     }
//
//     interface Counter {
//
//         void increment();
//
//         long getCounter();
//     }
//
//     static class CounterRunnable implements Runnable {
//
//         private final Counter counter;
//
//         private final int num;
//
//         public CounterRunnable(Counter counter, int num) {
//             this.counter = counter;
//             this.num = num;
//         }
//
//         @Override
//         public void run() {
//             for (int i = 0; i < num; i++) {
//                 counter.increment();
//             }
//         }
//     }
//
//     /**
//      * 自实现cas
//      */
//     static class CasCounter implements Counter {
//
//         private volatile long counter = 0;
//
//         private final Unsafe unsafe = getUnsafe();
//
//         private final long offset;
//
//         CasCounter() throws Exception {
//             long current = counter;
//             offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
//         }
//
//         @Override
//         public void increment() {
//             long current = counter;
//             while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
//                 current = counter;
//             }
//         }
//
//         @Override
//         public long getCounter() {
//             return counter;
//         }
//     }
//
//
//
// }
