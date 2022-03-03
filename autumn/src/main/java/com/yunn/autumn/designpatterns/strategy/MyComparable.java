package com.yunn.autumn.designpatterns.strategy;

/**
 * MyComparable
 *
 * @Author: Bff
 * @CreateTime: 2020-07-06
 * @Description: 自己的比较接口
 */
public interface MyComparable<T> {

    /**
     * 两数比较方法
     *
     * @param o
     * @return
     */
    int compareTo(T o);

}
