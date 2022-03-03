package com.yunn.autumn.designpatterns.strategy;

/**
 * Dog
 *
 */
public class Dog implements Comparator<Dog> {


    /**
     * dog类的排序规则
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Dog o1, Dog o2) {
        return 0;
    }
}
