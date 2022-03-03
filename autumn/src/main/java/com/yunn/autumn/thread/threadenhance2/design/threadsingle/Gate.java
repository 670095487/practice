package com.yunn.autumn.thread.threadenhance2.design.threadsingle;

/*
 * Gate
 *
 * @author: yunN
 * @createTime: 2021/01/13
 * @description: 单线程执行模式，有一个门 始终只有一个人通过
 */

/**
 * 角色--门 是共享资源
 * @author yunN
 */
public class Gate {

    private int counter = 0;

    private String name = "Nobody";

    private String address = "Nowhere";

    /**
     * 判断是否允许调用者通过
     * 临界值
     * @param name /
     * @param address /
     */
    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        verify();
    }

    /**
     * 校验名字和地址的首字母是否保持一致
     */
    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("***********BROKEN***********" + toString());
        }
    }

    @Override
    public String toString() {
        return "No." + counter + ":" + name + "," + address;
    }
}
