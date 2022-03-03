package com.yunn.interview;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * SingleDesign
 *
 * @author yunN
 * @createTime 2021年03月05日 10:21
 * @description
 */
public class SingleDesign {
    //单例【懒加载】设计模式实现：1.静态内部类 2.枚举
    private static class InstanceHolder {
        private final static SingleDesign SINGLE_DESIGN = new SingleDesign();
    }

    public static SingleDesign returnSingleDesignObject() {
        return InstanceHolder.SINGLE_DESIGN;
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(0, 100).forEach(i -> new Thread(() -> {
            System.out.println(SingleDesign.returnSingleDesignObject().hashCode());
        }).start());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        System.out.println("***********");
        IntStream.rangeClosed(1,100).forEach(i->new Thread(()->{
            System.out.println(SingleInstance.returnSingleDesignObject().hashCode());
        }).start());
    }
}

enum SingleInstance {
    INSTANCE;

    private SingleDesign singleDesign;

    SingleInstance() {
        this.singleDesign = new SingleDesign();
    }

    public static SingleDesign returnSingleDesignObject() {
        return INSTANCE.singleDesign;
    }
}


