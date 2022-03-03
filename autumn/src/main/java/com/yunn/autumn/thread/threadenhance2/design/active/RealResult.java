package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * RealResult
 *
 * @author yunN
 * @createTime 2021年01月22日 14:14
 * @description
 */
public class RealResult implements Result {

    private final Object resultValue;

    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return this.resultValue;
    }
}
