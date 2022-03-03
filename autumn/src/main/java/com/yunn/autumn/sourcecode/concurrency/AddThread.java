package com.yunn.autumn.sourcecode.concurrency;

import lombok.SneakyThrows;

/**
 * MyConcurrency
 *
 * @author: yunN
 * @createTime: 2020年10月21日 17:39
 * @description:
 */
public class AddThread extends Thread {


    private Obj obj;

    public AddThread(Obj obj) {
        this.obj = obj;
    }

    @SneakyThrows//lombok注解
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            obj.addCount();
        }
    }
}
