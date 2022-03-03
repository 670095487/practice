package com.yunn.autumn.thread.threadenhance2.design.practicedesign;

import java.util.stream.IntStream;

/**
 * SingleDesignByEnum
 *
 * @author yunN
 * @createTime 2021年01月17日 13:20
 * @description 使用枚举类实现一个安全的单例模式
 */
public class NoSingle {

    private final static NoSingle SINGLE_DESIGN_BY_ENUM = new NoSingle();

    //多例
    public NoSingle getSingleDesignByEnum() {
        return SINGLE_DESIGN_BY_ENUM;
    }
}

/**
 * 单例
 * double check
 */
class SingleDesignByDoubleCheck {

    /**
     * 使用 volatile 关键字 禁止JVM重排序
     */
    private static volatile SingleDesignByDoubleCheck SINGLE_DESIGN_BY_ENUM_2;

    //double check
    public static SingleDesignByDoubleCheck getSingleByDoubleCheck() {
        if (null == SINGLE_DESIGN_BY_ENUM_2) {
            synchronized (SingleDesignByDoubleCheck.class) {
                if (null == SINGLE_DESIGN_BY_ENUM_2) SINGLE_DESIGN_BY_ENUM_2 = new SingleDesignByDoubleCheck();
            }
        }
        return SINGLE_DESIGN_BY_ENUM_2;
    }

    public static void main(String[] args) {
        // System.out.println(getSingleDesignByEnum2().hashCode());
        IntStream.rangeClosed(1, 50).forEach(i -> {
            new Thread(() -> {
                System.out.println(getSingleByDoubleCheck().hashCode());
            }).start();
        });

    }
}

/**
 * 使用静态内部类实现 单例模式
 */
class SingleDesignByStaticClazz {


    private static class SingleHolder {
        private static final SingleDesignByStaticClazz singleDesignByStaticClazz = new SingleDesignByStaticClazz();
    }

    public static SingleDesignByStaticClazz getInstance() {
        return SingleHolder.singleDesignByStaticClazz;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                System.out.println(getInstance().hashCode()));
    }
}

/**
 * 使用枚举类实现 单例模式
 */
class SingleDesignByEnum {

    private enum SingleEnum {
        INSTANCE;

        private final SingleDesignByEnum singleDesignByEnum;

        SingleEnum() {
            singleDesignByEnum = new SingleDesignByEnum();
        }

        public static SingleDesignByEnum getInstance() {
            return INSTANCE.getVal();
        }

        private SingleDesignByEnum getVal() {
            return INSTANCE.singleDesignByEnum;
        }
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            new Thread(() ->
                    System.out.println(SingleDesignByEnum.SingleEnum.getInstance().hashCode())).start();
        });
    }

}
