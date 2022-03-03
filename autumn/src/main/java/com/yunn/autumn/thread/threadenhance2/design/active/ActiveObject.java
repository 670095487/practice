package com.yunn.autumn.thread.threadenhance2.design.active;

/**
 * ActiveObject
 *
 * @author yunN
 * @createTime 2021年01月22日 14:02
 * @description 接受异步消息的主动对象
 */
public interface ActiveObject {

    Result makeString(int count, char fillChar);

    void disPlayString(String text);

}
