package com.yunn.autumn.thread.threadenhance2.design.rwlock;

import java.util.Random;

/**
 * WriterWork
 *
 * @author: yunN
 * @createTime: 2021/01/14
 * @description:
 */
public class WriterWork extends Thread {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private final ShareData data;

    private final String filler;

    private int index = 0;

    public WriterWork(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            System.out.println("++++++++ 写线程执行了 ++++++++");
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
