package com.yunn.autumn.thread.threadenhance2.classloader;

import org.junit.Test;

/**
 * ThreadContextClassLoader
 *
 * @author: yunN
 * @createTime: 2021/01/25 20:02:41
 * @description:
 */
@SuppressWarnings("all")
public class ThreadContextClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Thread.currentThread().getContextClassLoader());
        /*
        * 静态代码块会防止clinit<>()方法中执行
        * */
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        System.out.println(aClass.getClassLoader());
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Test
    public void test01() {
        String str = "01";
        if (!str.equals("00") || str.equals("01")) {
            System.out.println("allowed");
        }
    }
}
