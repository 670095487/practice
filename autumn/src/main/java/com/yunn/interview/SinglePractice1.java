package com.yunn.interview;

import java.util.stream.IntStream;

/**
 * SinglePractice1
 *
 * @author yunN
 * @createTime 2021年03月08日 15:57
 * @description
 */
public class SinglePractice1 {

    static class InstanceHolder {
        private final static SinglePractice1 singlePractice1 = new SinglePractice1();
    }

    public static SinglePractice1 getSingleInstance()  {
        return InstanceHolder.singlePractice1;
    }
}

/**
 * 使用枚举
 */
enum SingleInstance1 {

    INSTANCE;

    private final SinglePractice1 singlePractice1;

    SingleInstance1() {
        this.singlePractice1 = new SinglePractice1();
    }

    public SinglePractice1 returnSingleInstance() {
        return INSTANCE.singlePractice1;
    }
}

class Application{
    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i->{new Thread(()-> System.out.println(SinglePractice1.getSingleInstance().hashCode())).start();});
    }
}
