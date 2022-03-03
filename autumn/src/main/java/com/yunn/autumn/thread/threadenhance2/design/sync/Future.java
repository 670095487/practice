package com.yunn.autumn.thread.threadenhance2.design.sync;

/**
 * Future
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description:
 */
public interface Future <T>{

    /**
     * 模拟业务逻辑
     * @return .
     * @throws InterruptedException .
     */
    T get() throws InterruptedException;
}
