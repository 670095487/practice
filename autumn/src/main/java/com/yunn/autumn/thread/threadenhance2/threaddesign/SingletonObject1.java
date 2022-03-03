package com.yunn.autumn.thread.threadenhance2.threaddesign;

/**
 * SingletonObject1
 *
 * @author yunnuan
 * @createTime 2021年01月10日 15:20
 * @description 单例设计模式-饿汉式、以及双重检查模式省略 直接以最终版示例
 */
public class SingletonObject1 {
    /*
     *此种写法可以保证单例且懒加载
     *使用静态内部类，由于jvm加载规范 保证一个class文件只会被加载一次，且静态内部类是使用时加载，
     * 所以保证了线程安全以及懒加载
     * */
    private SingletonObject1() {
    }

    private static class InstanceHolder {
        private final static SingletonObject1 SINGLETON_OBJECT_1 = new SingletonObject1();
    }

    public static SingletonObject1 getInstance() {
        return InstanceHolder.SINGLETON_OBJECT_1;
    }

    /**
     * 模拟100个线程同时获取此类的实例对象，看结果是否是同一个
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //创建线程并启动
            new Thread(() ->
                    System.out.println(SingletonObject1.getInstance().hashCode())).start();
        }
    }
}
