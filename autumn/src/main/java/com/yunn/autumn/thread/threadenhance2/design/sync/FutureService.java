package com.yunn.autumn.thread.threadenhance2.design.sync;

import java.util.function.Consumer;

/**
 * FutureService
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description:
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }



    public <T> Future<T> submit(final FutureTask<T> task, Consumer<T> consumer) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
            //结束以后结果给consumer ，让consumer去通知调用者 callback思想
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
