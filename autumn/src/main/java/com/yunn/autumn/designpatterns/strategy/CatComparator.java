package com.yunn.autumn.designpatterns.strategy;

/**
 * CatComparator
 *
 */
public class CatComparator implements Comparator<Cat> {
    /**
     * 按照猫咪的身高进行排序
     *
     */
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.getHeight() > o2.getHeight()) {
            return 1;
        } else if (o1.getHeight() < o2.getHeight()) {
            return -1;
        } else {
            return 0;
        }
    }
}
