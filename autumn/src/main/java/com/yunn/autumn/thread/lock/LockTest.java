package com.yunn.autumn.thread.lock;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * LockTest
 *
 * @author: yunN
 * @createTime: 2021/01/04
 * @description: 测试自己写的锁
 */
public class LockTest {

    public static void main(String[] args) {
        final BooleanMyLock booleanMyLock = new BooleanMyLock();
        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name -> new Thread(() -> {//循环创建线程，变量name可以直接创建，函数式推导，省略string name
                            try {
                                booleanMyLock.lock(1000L);
                                Optional.of(Thread.currentThread().getName() + " 持有锁")
                                        .ifPresent(System.out::println);
                                work();
                            } catch (InterruptedException e) {
                                System.out.println("线程被中断了");
                            } catch (MyLock.TimeOutException e) {
                                Optional.of(Thread.currentThread().getName() + " 等待超时了")
                                        .ifPresent(System.out::println);
                            } finally {
                                booleanMyLock.unlock();
                            }
                        }, name).start()
                );
    }

    /**
     * 模拟业务线程运行逻辑
     *
     * @throws InterruptedException /
     */
    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is Working . . .")
                .ifPresent(System.out::println);
        Thread.sleep(10_000);
    }
}
