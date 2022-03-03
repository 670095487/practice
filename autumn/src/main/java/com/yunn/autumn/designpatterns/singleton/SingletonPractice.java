package com.yunn.autumn.designpatterns.singleton;

import com.yunn.interview.SinglePractice1;

/**
 * SingletonPractice
 *
 * @author yunN
 * @createTime 2021年03月25日 17:05
 * @description
 */
public class SingletonPractice {


    /*
        静态内部类实现单例
     */
    static class InstanceHolder {
        private final static SinglePractice1 singlePractice1 = new SinglePractice1();


        public static SinglePractice1 getSinglePractice1() {
            return InstanceHolder.singlePractice1;
        }
    }


}


/**
 * 枚举类实现单例
 */
enum SingleEnumFor1 {

    INSTANCE;

    private SinglePractice1 singlePractice1;

    SingleEnumFor1() {
        this.singlePractice1 = new SinglePractice1();
    }

    public static SinglePractice1 getSinglePractice1() {
        return INSTANCE.singlePractice1;
    }
}