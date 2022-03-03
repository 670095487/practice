package com.yunn.autumn.sourcecode.concurrency;

import lombok.SneakyThrows;

/**
 * SubtractThread
 *
 * @author: yunN
 * @createTime: 2020年10月21日 17:48
 * @description:
 */
public class SubtractThread extends Thread {
    private Obj obj;

    public SubtractThread(Obj obj) {
        this.obj = obj;
    }

    @SneakyThrows//lombok注解
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            obj.subtractCount();
        }
    }
}
