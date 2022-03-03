package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * Servant
 *
 * @author yunN
 * @createTime 2021年01月22日 14:10
 * @description 对外暴露做事情的类
 */
public class Servant implements ActiveObject {


    @Override
    public Result makeString(int count, char fillChar) {
        char[] buf = new char[count];

        for (int i = 0; i < count; i++) {
            buf[i] = fillChar;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void disPlayString(String text) {
        try {
            System.out.println("Display : " + text);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
