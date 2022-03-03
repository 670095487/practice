package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * ActiveObjectProxy
 *
 * @author yunN
 * @createTime 2021年01月22日 20:37
 * @description 代理类 使用 TODO 不是很懂。。。
 */
public class ActiveObjectProxy implements ActiveObject {

    //直接操作任务队列的线程
    private final SchedulerThread schedulerThread;

    //具体需要做的事情
    private final Servant servant;

    public ActiveObjectProxy(SchedulerThread schedulerThread, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult futureResult = new FutureResult();
        //代理类执行 TODO 不是很懂。。。
        schedulerThread.invoke(new MakeStringRequest(servant, futureResult, count, fillChar));
        return futureResult;
    }

    /**
     * 展示所接收到的字符串
     *
     * @param text /
     */
    @Override
    public void disPlayString(String text) {
        // TODO 不是很懂。。。
        schedulerThread.invoke(new DisplayStringRequest(servant, text));
    }
}
