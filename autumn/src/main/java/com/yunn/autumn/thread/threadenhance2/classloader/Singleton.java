package com.yunn.autumn.thread.threadenhance2.classloader;

/**
 * Singleton
 *
 * @author: yunN
 * @createTime: 2021/01/23 17:12:12
 * @description:
 */
public class Singleton {

    public static int x = 0;
    public static int y ;

    private static Singleton instance = new Singleton();

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = getInstance();
        System.out.println(Singleton.x++);
        System.out.println(Singleton.y++);
    }
}
