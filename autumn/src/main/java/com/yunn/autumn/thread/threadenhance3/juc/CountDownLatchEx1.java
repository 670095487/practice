package com.yunn.autumn.thread.threadenhance3.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchEx1
 *
 * @author: yunN
 * @createTime: 2021/01/30 14:26:02
 * @description:
 */
public class CountDownLatchEx1 {

    private static final Random random = new Random(System.currentTimeMillis());

    private static final ExecutorService pools = Executors.newFixedThreadPool(2);

    private static final CountDownLatch latch = new CountDownLatch(query().length);

    public static void main(String[] args) throws InterruptedException {
        int[] data = query();
        for (int i = 0; i < data.length; i++) {
            pools.execute(new SimpleRunnable(data, i, latch));
        }
        latch.await();
        System.out.println("all of work had finished ...");
        pools.shutdown();
    }

    static class SimpleRunnable implements Runnable {

        private final int[] data;

        private final int index;

        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = data[index];

            if (value % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value * 10;
            }
            System.out.println(Thread.currentThread().getName() + "  finished");
            latch.countDown();
        }
    }

    /**
     * 模拟从数据库中查数据
     *
     * @return /
     */
    private static int[] query() {
        return new int[]{1, 2, 3, 7, 8, 9, 10};
    }
}
