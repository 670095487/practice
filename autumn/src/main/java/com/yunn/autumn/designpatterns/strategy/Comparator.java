package com.yunn.autumn.designpatterns.strategy;

/**
 * Comparator
 *
 */
@FunctionalInterface
public interface Comparator<T> {
    /**
     * 比较大小：
     * o1 > o2 return 1
     * o1 < o2 return -1
     * o1 = o2 return 0
     */
    int compare(T o1, T o2);


    default void sayHello() {
        System.out.println("1.8以后接口里可以有默认方法实现");
    }
}
