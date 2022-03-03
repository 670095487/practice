package com.yunn.autumn.designpatterns.singleton;

/**
 * Singleton1
 *
 * @Author: Bff
 * @CreateTime: 2020-07-06
 * @Description: 单例模式1---饿汉式
 */
public class Singleton1 {

    /**
     * 定义一个循环次数变量
     */
    private static Integer NUM;

    /**
     * 1、初始化静态实例变量
     */
    public static Singleton1 INSTANCE = new Singleton1();

    /**
     * 2、私有化构造方法，防止其他途径实例化
     */
    private Singleton1() {
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
    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    /**
     * 模拟100个线程同时获取此类的实例对象，看结果是否是同一个
     */
    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            //创建线程并启动
            new Thread(() ->
                    System.out.println(Singleton1.getInstance().hashCode())).start();
        }
    }
}
