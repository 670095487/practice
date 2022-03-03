package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * MethodRequest
 *
 * @author yunN
 * @createTime 2021年01月22日 14:07
 * @description 对应 ActiveObject 的每一个方法
 */
public abstract class MethodRequest {

    protected Servant servant;

    protected FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
