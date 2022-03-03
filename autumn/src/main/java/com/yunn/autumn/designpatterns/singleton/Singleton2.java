package com.yunn.autumn.designpatterns.singleton;

/**
 * Singleton2
 *
 * @Author: Bff
 * @CreateTime: 2019-07-06
 * @Description: 懒汉式---线程安全/不大范围影响写法
 */
public class Singleton2 {

    /**
     * 定义一个循环次数变量
     */
    private static final Integer NUM = 100;

    /**
     * 1、初始化静态实例变量
     */
    public static volatile Singleton2 INSTANCE;

    /**
     * 2、私有化构造方法，防止其他途径实例化
     */
    private Singleton2() {
    }

    /**
     * 模拟业务代码
     */
    public void m() {
        System.out.println("……");
    }

    /**
     * @return 返回当前类的实例变量
     */
    public static Singleton2 getInstance() {
        //1.第一次判断是否未实例化
        if (null == INSTANCE) {
            //模拟业务代码执行耗时
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton2.class) {
                //2.使用同步关键字进入，且在实例化前再判断一次是否已经实例化
                if (null == INSTANCE) {
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 模拟100个线程同时获取此类的实例对象，看结果是否是同一个
     */
    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            //创建线程并启动
            new Thread(() ->
                    System.out.println(Singleton2.getInstance().hashCode())).start();
        }
    }
}
