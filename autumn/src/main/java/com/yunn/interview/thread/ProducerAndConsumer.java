package com.yunn.interview.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * ProducerAndConsumer
 *
 * @author: yunN
 * @createTime: 2021/02/09 10:10:19
 * @description: 生产者-消费者:多线程模式
 */
public class ProducerAndConsumer {

    //任务队列
    private static final LinkedList<Long> pcMissisonList = new LinkedList<>();

    //任务队列最大处理任务数
    private static final int queueMaxnum = 100;

    //reentrylock
    private static final ReentrantLock LOCK = new ReentrantLock();

    //生产者lock
    private static final Condition CONDITION_PRODUCER = LOCK.newCondition();

    //消费者lock
    private static final Condition CONDITION_CONSUMER = LOCK.newCondition();

    public static void main(String[] args) {

        IntStream.range(0, 2).boxed().forEach(i ->
            new Thread(() -> {
                while (true) {
                    producer();
                    sleep(3);
                }
            }).start()
        );

        IntStream.range(0, 10).boxed().forEach(i -> {
            new Thread(() -> {
                while (true) {
                    consumer();
                    sleep(1);
                }
            }).start();
        });
    }

    //线程休眠
    private static void sleep(long sleepTime) {
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void producer() {
        try {
            LOCK.lock();
            //此处判断不能使用if().
            while (pcMissisonList.size() >= queueMaxnum) {
                CONDITION_PRODUCER.await();
            }
            long value = System.currentTimeMillis();
            pcMissisonList.addLast(value);
            System.out.println("P->" + Thread.currentThread().getName() + " value = " + value);
            CONDITION_CONSUMER.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }

    }

    private static void consumer() {
        try {
            LOCK.lock();
            while (pcMissisonList.isEmpty()) {
                CONDITION_CONSUMER.await();
            }
            Long result = pcMissisonList.removeFirst();
            System.out.println("C->" + Thread.currentThread().getName() + " result = " + result);
            CONDITION_PRODUCER.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}


