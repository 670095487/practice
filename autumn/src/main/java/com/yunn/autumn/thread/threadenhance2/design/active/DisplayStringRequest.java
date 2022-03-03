package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * DisplayStringRequest
 *
 * @author yunN
 * @createTime 2021年01月22日 18:51
 * @description 具体请求-做什么事情
 */
public class DisplayStringRequest extends MethodRequest {

    private final String text;

    public DisplayStringRequest(Servant servant, final String text) {
        super(servant, null);
        this.text = text;
    }

    @Override
    public void execute() {
        this.servant.disPlayString(text);
    }
}
