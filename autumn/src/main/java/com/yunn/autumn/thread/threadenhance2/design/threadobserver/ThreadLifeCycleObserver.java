package com.yunn.autumn.thread.threadenhance2.design.threadobserver;

import java.util.List;

/**
 * ThreadLifeCycleObserver
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description:
 */
public class ThreadLifeCycleObserver implements MyLifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> idList) {
        if (idList == null || idList.isEmpty()) {
            return;
        }
        idList.forEach(id -> new Thread(new ObserverRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for id " + id);
                    Thread.sleep(1000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        }, id).start());
    }


    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        //多线程操作，所以需要加锁
        synchronized (LOCK) {
            System.out.printf("线程 [%s] 状态已改变，现在的状态是 [%s] \n", Thread.currentThread().getName(), event.getState());
            if (null != event.getCause()) {
                System.out.printf("线程 [%s] 执行失败，失败原因 [%s] \n", Thread.currentThread().getName(), event.getCause());
            }
        }
    }
}
