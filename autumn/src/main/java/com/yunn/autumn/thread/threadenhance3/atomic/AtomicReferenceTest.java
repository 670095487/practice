package com.yunn.autumn.thread.threadenhance3.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReferenceTest
 *
 * @author: yunN
 * @createTime: 2021/01/28 15:24:43
 * @description:
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        //将自己定义的引用型对象转化为类型安全的对象
        AtomicReference<Simple> yunN = new AtomicReference<>(new Simple("yunN", 25));
    }

    static class Simple {
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}


