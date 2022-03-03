package com.yunn.autumn.thread.threadenhance2.threaddesign;

import java.util.stream.IntStream;

/**
 * SingletonObject2
 *
 * @author yunnuan
 * @createTime 2021年01月10日 16:05
 * @description 使用'枚举类' 实现 -> 单例+懒加载
 */
public class SingletonObject2 {


    public static SingletonObject2 getSingleInstance() {
        return SingletonEnum.INSTANCE.getSingle();
    }

    /*
     * 验证多线程下返回的是否是一个实例
     * */
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 40)
                .forEach(i -> new Thread(() -> {
                    System.out.println(SingletonObject2.getSingleInstance().hashCode());
                }).start());
    }

}

enum SingletonEnum {
    INSTANCE;

    private final SingletonObject2 singletonObject2;

    SingletonEnum() {
        singletonObject2 = new SingletonObject2();
    }

    public SingletonObject2 getSingle() {
        return singletonObject2;
    }
}
