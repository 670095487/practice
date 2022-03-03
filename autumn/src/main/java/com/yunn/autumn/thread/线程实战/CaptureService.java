package com.yunn.autumn.thread.线程实战;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * CaptureService
 *
 * @author yunnuan
 * @createTime 2021年01月02日 20:43
 * @description : 使用多线程采集数据,限定每次处理的任务个数。
 */
public class CaptureService {

    private final static LinkedList<Control> CONTROLS = new LinkedList<>();

    private final static int MAX_VALUES = 5;

    public static void main(String[] args) {

        List<Thread> workerList = new ArrayList<>();

        Stream.of("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10")//将一个String数组转化为一个作业流
                .map(CaptureService::createCaptureThread)//使用map()将String通过createCaptureThread(String name)转化为Thread
                .forEach(thread -> {//通过forEach()终止流
                    thread.start();//启动任务调度线程
                    workerList.add(thread);
                });
        //让线程工作且进入join态
        workerList.forEach(thread -> {
            try {
                thread.join();//主线程发起阻塞,等待所有被阻塞线程结束以后,主线程才会结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("所有的采集数据线程已经结束").ifPresent(System.out::println);
    }

    /**
     * 创建一个自定义名字的线程，逻辑部分也直接写好
     *
     * @param name /
     * @return /
     */
    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("工作线程 [" + Thread.currentThread().getName() + "] 开始准备收集信息了").ifPresent(System.out::println);
            //添加任务加锁，防止多增加
            synchronized (CONTROLS) {
                //等待执行的任务已经超过 MAX_VALUES 个，就让当前需要执行的任务等待，否则就创建新的任务加入任务集合
                while (CONTROLS.size() > MAX_VALUES) {
                    try {
                        CONTROLS.wait();
                        System.out.println("线程 [" + Thread.currentThread().getName() + "] 进入等待了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            Optional.of("工作线程 [" + Thread.currentThread().getName() + "] 已经开始收集信息了").ifPresent(System.out::println);

            //模拟实际业务逻辑耗时
            try {
                Thread.sleep(1000);
                Optional.of("工作线程 [" + Thread.currentThread().getName() + "] 开始处理逻辑了").ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //删除任务加锁，防止多删
            synchronized (CONTROLS) {
                Optional.of("工作线程 [" + Thread.currentThread().getName() + "] 收集信息已经结束了").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);
    }

    private static class Control {
    }


}
