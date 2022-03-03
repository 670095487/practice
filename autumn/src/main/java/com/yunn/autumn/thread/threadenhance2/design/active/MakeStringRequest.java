package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * MakeStringRequest
 *
 * @author yunN
 * @createTime 2021年01月22日 18:28
 * @description 具体请求-做什么事情
 */
public class MakeStringRequest extends MethodRequest {

    private final int count;

    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);
    }
}
