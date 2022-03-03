package com.yunn.autumn.thread.th06;

import java.util.*;

/**
 * CaptureService
 *
 * @Author: Bff
 * @CreateTime: 2020-05-07
 * @Description: 一个综合小案例
 * 简单描述：有10个线程，但是每次只允许5个线程去运行
 * 疑问：Java8的流式语法不太懂
 */
public class CaptureService {

    private static final LinkedList<Control> controls = new LinkedList<>();

    private static final int MAX_THREAD = 4;

    public static void main(String[] args) {

        List<Thread> worker = new ArrayList<>();

        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10")
                .stream()
                .map(CaptureService::createCaptureThread)
                .forEach(thread -> {
                    thread.start();
                    worker.add(thread);
                });

        worker.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of capture work finished").ifPresent(System.out::println);
    }

    private static Thread createCaptureThread(String name) {

        return new Thread(() -> {
            Optional.of("the worker [" + Thread.currentThread().getName() + "] begin capture data.")
                    .ifPresent(System.out::println);
            synchronized (controls) {
                while (controls.size() > MAX_THREAD) {
                    try {
                        controls.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                controls.addLast(new Control());
            }

            Optional.of("the worker [" + Thread.currentThread().getName() + "]  is working...")
                    .ifPresent(System.out::println);

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (controls) {
                Optional.of("the worker [" + Thread.currentThread().getName() + "] end capture data.")
                        .ifPresent(System.out::println);
                controls.removeFirst();
                controls.notifyAll();
            }
        }, name);
    }

    public static class Control {
    }

}
