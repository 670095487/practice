package com.yunn.autumn.thread.threadenhance2.design.produceconsumer;

/**
 * Message
 *
 * @author: yunN
 * @createTime: 2021/01/18
 * @description:
 */
public class Message {

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Message(String value) {
        this.value = value;
    }
}
