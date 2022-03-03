package com.yunn.autumn.thread.threadenhance2.design.classLoader;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Description
 *
 * @author yunN
 * @createTime 2021年01月24日 08:47
 * @description 简单介绍classLoader
 * <p>
 * <p>
 * 1. 类加载器的委托是优先交给父加载器先去尝试加载
 * 2. 父加载器和子加载器其实是一种包装关系，或者包含关系
 */
@SuppressWarnings("all")
public class Description {

    private static int x = 10;

    static {
        // System.out.println(x);
        y = 100;//先于静态变量赋值，但是会被后面的静态变量赋值覆盖掉
    }

    private static int y = 1;

    public static void main(String[] args) throws InterruptedException {
        // System.out.println(y);

        new Thread(() -> {
            Description2 description1 = new Description2();
            System.out.println(Thread.currentThread().getName() + description1.hashCode());
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            Description2 description2 = new Description2();
            System.out.println(Thread.currentThread().getName() + description2.hashCode());
        }).start();
    }
}

/**
 * jvm有义务保证每个clint()方法线程安全 class init
 */
class Description2 {

    private static AtomicBoolean flag = new AtomicBoolean(true);

    /*
        一个类的静态代码块只会被执行一次
     */
    static {
        System.out.println(Thread.currentThread().getName() + " 初始化中....");
        while (flag.get()) {
            //
        }
        System.out.println(Thread.currentThread().getName() + " 初始化结束....");
    }
}





