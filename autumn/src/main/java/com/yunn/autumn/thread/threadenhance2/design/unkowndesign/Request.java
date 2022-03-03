package com.yunn.autumn.thread.threadenhance2.design.unkowndesign;

/**
 * Request
 *
 * @author: yunN
 * @createTime: 2021/01/15
 * @description: 请求实例
 */
public class Request {

    private final String value;

    public Request(String sendValue) {
        this.value = sendValue;
    }

    public String getValue() {
        return value;
    }
}
