package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * ActiveObjectFactory
 *
 * @author yunN
 * @createTime 2021年01月22日 20:49
 * @description
 */
public final class ActiveObjectFactory {


    /**
     * 封装
     */
    private ActiveObjectFactory() {
    }


    /**
     * 通过工厂方法创建代理对象返回,调用者本身完全不知道内部逻辑
     * @return /
     */
    public static ActiveObject createActiveObject() {
        //
        Servant servant = new Servant();
        //
        ActivationQueue queue = new ActivationQueue();
        //
        SchedulerThread schedulerThread = new SchedulerThread(queue);
        //生成静态代理，后续考虑优化为动态代理
        ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread, servant);
        schedulerThread.start();
        return proxy;
    }

}
