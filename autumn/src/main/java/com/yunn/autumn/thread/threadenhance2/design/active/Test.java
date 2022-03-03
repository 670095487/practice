package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * Test
 *
 * @author: yunN
 * @createTime: 2021/01/23 14:52:24
 * @description:
 */
public class Test {


    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread(activeObject,"Alice").start();
        new MakerClientThread(activeObject,"Bobby").start();
        new DisplayClientThread("Chris",activeObject).start();
    }
}
