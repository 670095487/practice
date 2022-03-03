package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * DisplayClientThread
 *
 * @author: yunN
 * @createTime: 2021/01/23 14:19:11
 * @description: 展示字符串的客户端线程
 */
public class DisplayClientThread extends Thread {

    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                String text = Thread.currentThread().getName() + "=>" + i;
                activeObject.disPlayString(text);
                Thread.sleep(200);
            }
        } catch (Exception e) {
            //
        }
    }
}
