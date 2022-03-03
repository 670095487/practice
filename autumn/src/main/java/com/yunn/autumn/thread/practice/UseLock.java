package com.yunn.autumn.thread.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

/**
 * UseLock
 *
 * @author: yunN
 * @createTime: 2020/09/23
 * @description: 使用lock锁
 */
@SuppressWarnings("all")
public class UseLock {

    /**
     * 乐观读写锁
     */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        // list.stream().filter(s -> s.startsWith("张"))
        //         .filter(s -> s.length() == 2)
        //         .forEach(s -> System.out.println(s));


        while (list.iterator().hasNext()) {
            String s = list.iterator().next();
            System.out.println(s);
        }
    }

    /**
     * @param string
     * @param con
     */
    private static void fun(String string, Consumer<String> con) {
        con.accept(string);
    }
}
