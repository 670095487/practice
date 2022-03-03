package com.yunn.autumn.designpatterns.strategy;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Main
 *
 * @Author: Bff
 * @CreateTime: 2020-07-06
 * @Description: 策略模式
 */
public class FactoryApplication {

    public static void main(String[] args) {
        Cat[] arr = {new Cat(3, 7), new Cat(2, 2), new Cat(1, 4)};
        // int[] arr = {4,5,1,3,2,5};
        SorterStrategy<Cat> catSorterStrategy = new SorterStrategy<>();
        CatComparator catComparator = new CatComparator();
        //调用接口里的默认实现方法
        catComparator.sayHello();
        //传入任意类型的数组+这种类型的比较方式（通过什么比较？）
        //比较器是需要自己去实现的，策略类仅提供算法
        catSorterStrategy.sort(arr, catComparator);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void assertTest() {
        // String s = null;
        // Cat cat = new Cat();
        // try {
        //     Assert.assertNotNull("为空",s);
        // } catch (Error e) {
        //     e.printStackTrace();
        //     cat.setHeight(0);
        // }
        // cat.setWeight(20);
        // System.out.println(cat.toString());
        BigDecimal b1 = new BigDecimal(40);
        BigDecimal b2 = new BigDecimal(40);
        if (b1.compareTo(b2) > 0) {
            System.out.println("goggogogo");
        }
    }
}
